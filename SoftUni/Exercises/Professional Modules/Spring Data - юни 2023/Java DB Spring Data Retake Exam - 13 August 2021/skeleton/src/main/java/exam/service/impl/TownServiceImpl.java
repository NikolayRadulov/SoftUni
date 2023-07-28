package exam.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.bind.JAXBException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import exam.model.dto.ImportTownDto;
import exam.model.dto.ImportTownsDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParserer;

@Service
public class TownServiceImpl implements TownService {

	
	public static final String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";
	
	private final TownRepository townRepository;
	private final XmlParserer xmlParserer;
	private final ValidationUtil validationUtil;
	private final ModelMapper modelMapper;
	
	public TownServiceImpl(XmlParserer xmlParserer, ValidationUtil validationUtil, TownRepository townRepository, ModelMapper modelMapper) {
		this.townRepository = townRepository;
		this.xmlParserer = xmlParserer;
		this.validationUtil = validationUtil;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean areImported() {
		// TODO Auto-generated method stub
		return townRepository.count() > 0;
	}

	@Override
	public String readTownsFileContent() throws IOException {
		// TODO Auto-generated method stub
		return Files.readString(Path.of(TOWNS_FILE_PATH));
	}

	@Override
	public String importTowns() throws JAXBException, FileNotFoundException {
		ImportTownsDto importTownsDto = xmlParserer.fromFile(Path.of(TOWNS_FILE_PATH).toFile(), ImportTownsDto.class);
		StringBuilder builder = new StringBuilder();
		
		
		for (ImportTownDto dto : importTownsDto.getDtos()) {
			if(!validationUtil.isValid(dto) || townRepository.findByName(dto.getName()) != null) {
				builder.append("Invalid town").append(System.lineSeparator());
				continue;
			}
			Town town = modelMapper.map(dto, Town.class);
			townRepository.save(town);
			builder.append("Successfully imported Town " + town.getName()).append(System.lineSeparator());		
		}
		
		return builder.toString().trim();
	}

}
