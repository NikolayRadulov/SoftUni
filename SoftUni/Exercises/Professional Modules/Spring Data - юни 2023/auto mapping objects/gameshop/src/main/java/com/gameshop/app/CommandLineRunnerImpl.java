package com.gameshop.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gameshop.app.service.GameService;
import com.gameshop.app.service.OrderService;
import com.gameshop.app.service.ShoppingCartService;
import com.gameshop.app.service.UserService;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

	private final Scanner sc;
	private final GameService gameService;
	private final ShoppingCartService shoppingCartService;
	private final UserService userService;
	private final OrderService orderService;
	
	public CommandLineRunnerImpl(UserService userService, ShoppingCartService shoppingCartService, OrderService orderService, GameService gameService) {
		this.gameService = gameService;
		this.shoppingCartService = shoppingCartService;
		this.userService = userService;
		this.orderService = orderService;
		sc = new Scanner(System.in);
	}

	@Override
	public void run(String... args) throws Exception {	
		int problem = Integer.parseInt(sc.nextLine());
		
		switch (problem){
			case 1: userSystem();
			break;
			case 2: gameSystem();
			break;
			case 3: gameInfoSystem();
			break;
			default: throw new IllegalArgumentException("No such problem " + problem);
			
		}

	}
	
	private void gameInfoSystem() {
		String command = sc.nextLine();
		
		while (!command.equals("End")) {
			String[] tokens = command.split("\\|");
			switch(tokens[0]) {
				case "AllGames": {
					gameService.printAllGamesInfo();
				}
				break;
				case "DetailGame": {
					gameService.printGameDetails(tokens[1]);
				}
				break;
				case "OwnedGames": {
					userService.printAllOwnedGames();
				}
				break;
				default: throw new IllegalArgumentException("Invalid command " + tokens[0]);
			}
			
			command = sc.nextLine();
		
		}
		try {
			run(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void gameSystem() {
		String command = sc.nextLine();
		
		while (!command.equals("End")) {
			String[] tokens = command.split("\\|");
			switch(tokens[0]) {
				case "AddGame": {
					final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					gameService.addGame(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), tokens[4], tokens[5], tokens[6], LocalDate.parse(tokens[7], DATE_FORMAT));
				}
				break;
				case "EditGame": {
					gameService.editGame(Integer.parseInt(tokens[1]), tokens[2]);;
				}
				break;
				case "DeleteGame": {
					gameService.deleteGame(Integer.parseInt(tokens[1]));
				}
				break;
				default: throw new IllegalArgumentException("Invalid command " + tokens[0]);
			}
			
			command = sc.nextLine();
		
		}
		try {
			run(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void userSystem() {
		String command = sc.nextLine();
		
		while (!command.equals("End")) {
			String[] tokens = command.split("\\|");
			
			switch(tokens[0]) {
				case "RegisterUser": {
					userService.registerUser(tokens[1], tokens[2], tokens[3], tokens[4]);
				}
				break;
				case "LoginUser": {
					userService.loginUser(tokens[1], tokens[2]);
				}
				break;
				case "Logout": {
					if(tokens.length == 2) userService.logoutUser(tokens[1]);
					else userService.logoutUser();
				}
				break;
				case "BuyGame": {
					userService.buyGame(tokens[1], gameService.getGame(tokens[2]));
				}
				break;
				default: throw new IllegalArgumentException("Invalid command " + tokens[0]);
			}
			
			command = sc.nextLine();
		}
		try {
			run(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public GameService getGameService() {
		return gameService;
	}

	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}

	public UserService getUserService() {
		return userService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

}
