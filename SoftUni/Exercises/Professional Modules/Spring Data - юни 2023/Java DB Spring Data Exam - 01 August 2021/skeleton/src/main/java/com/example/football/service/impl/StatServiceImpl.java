package com.example.football.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.bind.JAXBException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.football.models.dto.ImportStatDto;
import com.example.football.models.dto.ImportStatsDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;

@Service
public class StatServiceImpl implements StatService {

	private static final String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";
	
	private final StatRepository statRepository;
	private final ModelMapper mapper;
	private final ValidationUtil validationUtil;
	private final XmlParser xmlParser;
	
	
	public StatServiceImpl(StatRepository statRepository, ValidationUtil validationUtil, ModelMapper mapper, XmlParser xmlParser) {
		this.statRepository = statRepository;
		this.mapper = mapper;
		this.validationUtil = validationUtil;
		this.xmlParser = xmlParser;
	}

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException  {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() {
    	ImportStatsDto importStatsDto = null;
    	StringBuilder builder = new StringBuilder();
    	try {
			importStatsDto = xmlParser.fromFile(Path.of(STATS_FILE_PATH).toFile(), ImportStatsDto.class);
		} catch (FileNotFoundException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for (ImportStatDto dto : importStatsDto.getDtos()) {
			if(!validationUtil.isValid(dto) || statRepository.getByShootingAndPassingAndEndurance(dto.getShooting(), dto.getPassing(), dto.getEndurance()) != null) {
				builder.append("Invalid stat").append(System.lineSeparator());
				continue;
			}
			Stat stat = this.mapper.map(dto, Stat.class);
			
			builder.append(String.format("Successfully imported stat %.2f - %.2f - %.2f", stat.getShooting(), stat.getPassing(), stat.getEndurance())).append(System.lineSeparator());
			statRepository.save(stat);
    	}
    	
        return builder.toString().trim();
    }
}
