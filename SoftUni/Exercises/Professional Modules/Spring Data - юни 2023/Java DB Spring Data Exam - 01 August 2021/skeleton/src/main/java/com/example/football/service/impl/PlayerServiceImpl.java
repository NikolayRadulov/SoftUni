package com.example.football.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.football.models.dto.ImportPlayerDto;
import com.example.football.models.dto.ImportPlayersDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;


@Service
public class PlayerServiceImpl implements PlayerService {

	private static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";
	
	private final PlayerRepository playerRepository;
	private final StatRepository statRepository;
	private final TeamRepository teamRepository;
	private final TownRepository townRepository;
	private final ValidationUtil validationUtil;
	private final ModelMapper mapper;
	private final XmlParser parser;

    public PlayerServiceImpl(PlayerRepository playerRepository, StatRepository statRepository,
			TeamRepository teamRepository, TownRepository townRepository, ValidationUtil validationUtil,
			ModelMapper mapper, XmlParser parser) {
		this.playerRepository = playerRepository;
		this.statRepository = statRepository;
		this.teamRepository = teamRepository;
		this.townRepository = townRepository;
		this.validationUtil = validationUtil;
		this.mapper = mapper;
		this.parser = parser;
	}

	@Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException  {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers()  {
    	ImportPlayersDto importPlayersDto = null;
    	StringBuilder builder = new StringBuilder();
    	try {
			importPlayersDto = parser.fromFile(Path.of(PLAYERS_FILE_PATH).toFile(), ImportPlayersDto.class);
		} catch (FileNotFoundException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for (ImportPlayerDto dto : importPlayersDto.getDtos()) {
			if(!validationUtil.isValid(dto) || playerRepository.getByEmail(dto.getEmail()) != null) {
				builder.append("Invalid player").append(System.lineSeparator());
				continue;
			}
			Player player = this.mapper.map(dto, Player.class);
			
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			player.setBirthDate(LocalDate.parse(dto.getBirthDate(), dateFormatter));
			player.setTown(townRepository.getByName(dto.getTownBase().getName()));
			player.setTeam(teamRepository.getByName(dto.getTeamBase().getName()));
			player.setStat(statRepository.findById(dto.getStatBase().getId()).get());
			
			playerRepository.save(player);
			
			builder.append("Successfully imported player " + player.getFirstName() + " " + player.getLastName() + " - " + player.getPosition()).append(System.lineSeparator());
		}
    	
        return builder.toString().trim();
    }

    @Override
    public String exportBestPlayers() {
    	List<Player> players = playerRepository.findOrderedPlayers();
    	StringBuilder builder = new StringBuilder();
    	
    	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	
    	for(Player player : players) {
    		if(player.getBirthDate().isBefore(LocalDate.parse("01-01-1995", dateTimeFormatter)) || player.getBirthDate().isAfter(LocalDate.parse("01-01-2003", dateTimeFormatter))) {
    			continue;
    		}
    		builder.append(String.format("Player - %s %s", player.getFirstName(), player.getLastName())).append(System.lineSeparator());
    		builder.append("Position - " + player.getPosition()).append(System.lineSeparator());
    		builder.append("Team - " + player.getTeam().getName()).append(System.lineSeparator());
    		builder.append("Stadium - " + player.getTeam().getStadiumName()).append(System.lineSeparator());
    	}
    	
        return builder.toString().trim();
    }
}
