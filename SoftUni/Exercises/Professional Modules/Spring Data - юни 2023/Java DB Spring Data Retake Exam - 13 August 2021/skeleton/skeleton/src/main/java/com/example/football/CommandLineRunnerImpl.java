package com.example.football;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

	private final TeamService teamService;
	private final TownService townService;
	private final PlayerService playerService;
	private final StatService statService;
	
	public CommandLineRunnerImpl(TownService townService, TeamService teamService, StatService statService, PlayerService playerService) {
		this.teamService = teamService;
		this.townService = townService;
		this.playerService = playerService;
		this.statService = statService;
	}

	@Override
	public void run(String... args) throws Exception {
		if(!townService.areImported())System.out.println(townService.importTowns());
		if(!teamService.areImported())System.out.println(teamService.importTeams());
		if(!statService.areImported())System.out.println(statService.importStats());
		if(!playerService.areImported())System.out.println(playerService.importPlayers());
		
		System.out.println(playerService.exportBestPlayers());
	}

}
