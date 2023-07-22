package com.example.football.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.football.models.dto.ImportTeamDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Service
public class TeamServiceImpl implements TeamService {

	private final TeamRepository teamRepository;
	private final Gson gson;
	private final ValidationUtil validationUtil;
	private final ModelMapper mapper;
	private final TownRepository townRepository;
	
	public TeamServiceImpl(TeamRepository teamRepository, ValidationUtil validationUtil, ModelMapper mapper, Gson gson, TownRepository townRepository) {
		this.teamRepository = teamRepository;
		this.gson = gson;
		this.validationUtil = validationUtil;
		this.mapper = mapper;
		this.townRepository = townRepository;
	}
	
    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/teams.json"));
    }

    @Override
    public String importTeams() {
    	ImportTeamDto[] dtos = null;
    	StringBuilder builder = new StringBuilder();
    	try {
			 dtos = this.gson.fromJson(readTeamsFileContent(), ImportTeamDto[].class);
		} catch (JsonSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for (ImportTeamDto importTeamDto : dtos) {
			if(!validationUtil.isValid(importTeamDto) || teamRepository.getByName(importTeamDto.getName()) != null) {
				builder.append("Invalid team").append(System.lineSeparator());
				continue;
			}
			
			Team team = mapper.map(importTeamDto, Team.class);
			
			team.setTown(townRepository.getByName(importTeamDto.getTownName()));
			
			builder.append("Successfully imported Team " + team.getName() + " - " + team.getFanBase()).append(System.lineSeparator());
    		teamRepository.save(team);
		}
    	
        return builder.toString().trim();
    }
}
