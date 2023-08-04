package softuni.exam.service.impl;

import softuni.exam.models.dto.ImportMechanicsDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class MechanicsServiceImpl implements MechanicsService {
	
    private static String MECHANICS_FILE_PATH = "src/main/resources/files/json/mechanics.json";
    
    private final MechanicsRepository mechanicsRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

	
    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
		this.mechanicsRepository = mechanicsRepository;
		this.gson = gson;
		this.modelMapper = modelMapper;
		this.validationUtil = validationUtil;
	}

	@Override
    public boolean areImported() {
        return mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
		String content = readMechanicsFromFile();

    	ImportMechanicsDto[] dtos = this.gson.fromJson(content, ImportMechanicsDto[].class);
    	StringBuilder builder = new StringBuilder();
    	
    	for (ImportMechanicsDto importMechanicsDto : dtos) {
 
			Set<ConstraintViolation<ImportMechanicsDto>> violations = validationUtil.getConstraintViolation(importMechanicsDto);
			
			if(!violations.isEmpty() || mechanicsRepository.findByFirstName(importMechanicsDto.getFirstName()) != null) {
				builder.append("Invalid mechanic").append(System.lineSeparator());
				continue;
			}
			
			Mechanic mechanic = this.modelMapper.map(importMechanicsDto, Mechanic.class);
			
			this.mechanicsRepository.save(mechanic);
			
			builder.append("Successfully imported mechanic " + mechanic.getFirstName() + " " + mechanic.getLastName()).append(System.lineSeparator());
		}
        return builder.toString().trim();
    }
}
