package com.gameshop.app.service.impl;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.gameshop.app.entity.Game;
import com.gameshop.app.entity.User;
import com.gameshop.app.repository.UserRepository;
import com.gameshop.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private long lastLoggedInUserId;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.lastLoggedInUserId = -1;
	}

	@Override
	public void registerUser(String email, String password, String confirmPassword, String fullName) {
		if(!password.equals(confirmPassword)) {
			System.out.println("Password does not match confirm password");
			return;
		}
		boolean administrator= false;
		if(userRepository.count() == 0) administrator = true;
		User user = userRepository.findByEmail(email);
		if(user != null) {
			System.out.println("User is already registered.");
			return;
		}
		userRepository.save(new User(email, confirmPassword, fullName, new HashSet<>(), administrator));
		System.out.println(fullName + " was registered");
	}

	@Override
	public void loginUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		if(user == null || !user.getPassword().equals(password)) {
			System.out.println("Incorrect username / password");
			return;
		}
		lastLoggedInUserId = user.getId();
		user.logIn();
		userRepository.save(user);
		System.out.println("Successfully logged in " + user.getFullName());
	}

	@Override
	public void logoutUser() {
		logoutUser(null);		
	}

	@Override
	public void logoutUser(String email) {
		if(email == null) {
			if(lastLoggedInUserId == -1) {
				User checkUser = userRepository.findAll().stream().filter(user -> user.isLoggedIn()).findFirst().orElse(null);
				if(checkUser == null) System.out.println("Cannot logout. No user was logged in.");
				else {
					checkUser.logOut();
					userRepository.save(checkUser);
				}
				return;
			}
			User user = userRepository.findById(lastLoggedInUserId).get();
			user.logOut();
			userRepository.save(user);
			return;
		}
		User user = userRepository.findByEmail(email);
		if(user == null) {
			System.out.println("Invalid Email");
			return;
		}
		user.logOut();
		System.out.println("User " + user.getFullName() + " successfully logged out");
	}

	@Override
	public void printAllOwnedGames() {
		User user; 
		if(lastLoggedInUserId != -1)user = userRepository.findById(lastLoggedInUserId).get();
		else user = userRepository.findAll().stream().filter(user1 -> user1.isLoggedIn()).findFirst().orElse(null);
		
		if(user == null) {
			System.out.println("No user is logged in.");
			return;
		}
		for (Game game : user.getGames()) {
			System.out.println(game.getTitle());
		}
		
	}

	@Override
	public void buyGame(String email, Game game) {
		
		User user = userRepository.findByEmail(email);
		
		user.buyGame(game);
		
		userRepository.save(user);
	}

}
