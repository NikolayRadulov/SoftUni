package softuni.exam.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import softuni.exam.models.dto.ImportPartDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtil;

@Service
public class PartsServiceImpl implements PartsService {
	
    private static String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";

    private final PartsRepository partsRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;   
    
    
    public PartsServiceImpl(PartsRepository partsRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
		this.partsRepository = partsRepository;
		this.gson = gson;
		this.validationUtil = validationUtil;
		this.modelMapper = modelMapper;	
	}

	@Override
    public boolean areImported() {
        return partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        ImportPartDto[] dtos = this.gson.fromJson(readPartsFileContent(), ImportPartDto[].class);
    	StringBuilder builder = new StringBuilder();
    	
    	for (ImportPartDto importPartDto : dtos) {
			Set<ConstraintViolation<ImportPartDto>> violations = validationUtil.getConstraintViolation(importPartDto);
			
			if(!violations.isEmpty() || partsRepository.findByPartName(importPartDto.getPartName()) != null) {
				builder.append("Invalid part").append(System.lineSeparator());
				continue;
			}
			
			Part part = this.modelMapper.map(importPartDto, Part.class);
			
			this.partsRepository.save(part);
			
			builder.append("Successfully imported part " + part.getPartName() + " - " + part.getPrice()).append(System.lineSeparator());
		}
        return builder.toString().trim();
    }
}
