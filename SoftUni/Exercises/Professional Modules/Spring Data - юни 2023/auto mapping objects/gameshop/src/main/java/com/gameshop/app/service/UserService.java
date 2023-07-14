package com.gameshop.app.service;

import com.gameshop.app.entity.Game;

public interface UserService {
	
	void registerUser(String email, String password, String confirmPassword, String fullName);
	void loginUser(String email, String password);
	void logoutUser();
	void logoutUser(String email);
	void printAllOwnedGames();
	void buyGame(String email, Game game);

}
