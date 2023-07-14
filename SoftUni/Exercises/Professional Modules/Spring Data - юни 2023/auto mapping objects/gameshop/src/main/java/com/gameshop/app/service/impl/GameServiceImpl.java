package com.gameshop.app.service.impl;

import java.time.LocalDate;
import java.util.HashSet;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.gameshop.app.entity.Game;
import com.gameshop.app.entity.dto.GameDto;
import com.gameshop.app.repository.GameRepository;
import com.gameshop.app.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	private final GameRepository gameRepository;
	private final ModelMapper mapper;
	
	public GameServiceImpl(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
		mapper = new ModelMapper();
	}

	@Override
	public void addGame(String title, double price, double size, String trailor, String thumbnail, String description,
			LocalDate releaseDate) {
			Game game = new Game(title, price, size, trailor, thumbnail, description, releaseDate, new HashSet<>(), new HashSet<>());
		    gameRepository.save(game);
		    System.out.println("Added " + game.getTitle());
	}

	@Override
	public void editGame(long id, String values) {
		Game game = checkId(id);
		String[] tokens = values.split("\\|");
		for(int i = 0; i < tokens.length; i++) {
			String[] tokensOfTokens = tokens[i].split("\\=");
			switch (tokensOfTokens[0]) {
				case "title": game.setTitle(tokensOfTokens[1]);	
				break;
				case "price": game.setPrice(Double.parseDouble(tokensOfTokens[1]));
					break;
				case "size":  game.setSize(Double.parseDouble(tokensOfTokens[1]));
					break;
				case "trailer":	game.setTrailer(tokensOfTokens[1]);	
					break;
				case "thumbnail": game.setThumbnailPath(tokensOfTokens[1]);
					break;
				case "description":	game.setDescription(tokensOfTokens[1]);
					break;
				case "releaseDate":	game.setReleaseDate(LocalDate.parse(tokensOfTokens[1]));
					break;
				default: throw new IllegalArgumentException("Invalid property.");
			}
		}
		game.validate();
		gameRepository.save(game);
		System.out.println("Edited " + game.getTitle());
	}

	@Override
	public void deleteGame(long id) {
		Game game = checkId(id);
		gameRepository.delete(game);
		System.out.println("Deleted " + game.getTitle());
	}

	private Game checkId(long id) {
		Game game = gameRepository.findById(id).get();
		if(game == null) throw new IllegalArgumentException("Game missing.");
		return game;
	}

	@Override
	public void printAllGamesInfo() {
		gameRepository.findAll().forEach(game -> {
			GameDto gameDto = mapper.map(game, GameDto.class);
			System.out.println(gameDto.getInfo());
		});
		
	}

	@Override
	public void printGameDetails(String name) {
		GameDto gameDto = mapper.map(gameRepository.findByTitle(name), GameDto.class);
		System.out.println(gameDto.getDetailedInfo());
		
	}

	@Override
	public Game getGame(String title) {
		// TODO Auto-generated method stub
		return gameRepository.findByTitle(title);
	}
}
