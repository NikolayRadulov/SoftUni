package com.gameshop.app.service;

import java.time.LocalDate;

import com.gameshop.app.entity.Game;

public interface GameService {

	void addGame(String title, double price, double size, String trailor, String thumbnail, String description, LocalDate releaseDate);
	void editGame(long id, String valies);
	void deleteGame(long id);
	void printAllGamesInfo();
	void printGameDetails(String name);
	Game getGame(String title);
}
