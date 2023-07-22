package com.example.football.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.football.models.dto.ImportTownDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Service
public class TownServiceImpl implements TownService {

	private final TownRepository townRepository;
	private final Gson gson;
	private final ModelMapper mapper;
	private final ValidationUtil validationUtil;
	
	public TownServiceImpl(TownRepository townRepository, ValidationUtil validationUtil, ModelMapper mapper, Gson gson) {
		this.townRepository = townRepository;
		this.gson = gson;
		this.mapper = mapper;
		this.validationUtil = validationUtil;	
	}

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/towns.json"));
    }

    @Override
    public String importTowns() {
    	ImportTownDto[] dtos = null;
    	StringBuilder builder = new StringBuilder();
    	try {
			 dtos = this.gson.fromJson(readTownsFileContent(), ImportTownDto[].class);
		} catch (JsonSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for (ImportTownDto importTownDto : dtos) {
			if(!validationUtil.isValid(importTownDto) || townRepository.getByName(importTownDto.getName()) != null) {
				builder.append("Invalid town").append(System.lineSeparator());
				continue;
			}
			
			Town town = mapper.map(importTownDto, Town.class);
			
			builder.append("Successfully imported town " + town.getName() + " - " + town.getPopulation()).append(System.lineSeparator());
    		townRepository.save(town);
		}
    	
        return builder.toString().trim();
    }
}
