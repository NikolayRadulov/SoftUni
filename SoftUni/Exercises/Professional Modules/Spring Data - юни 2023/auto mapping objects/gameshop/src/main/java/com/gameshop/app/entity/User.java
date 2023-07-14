package com.gameshop.app.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	
	@Column(unique = true)
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String fullName;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(
		name = "users_games",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "game_id")
	)
	private Set<Game> games;
	
	@Column
	private boolean isAdministrator;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "shopping_cart_id")
	private ShoppingCart shoppingCart;
	
	@Column
	private boolean isLoggedIn;
	
	public User(String email, String password, String fullName, Set<Game> games, boolean isAdministrator) {
		this.setEmail(email);
		this.setPassword(password);;
		this.fullName = fullName;
		this.games = games;
		this.isAdministrator = isAdministrator;
		
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public void logIn() {
		this.isLoggedIn = true;
	}
	public void logOut() {
		this.isLoggedIn = false;
	}
	
	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(!email.contains("@") || !email.contains(".")) {
			throw new IllegalArgumentException("Incorrect email");
		}
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	
	public void buyGame(Game game) {
		this.games.add(game);
	}
	
	public void setPassword(String password) {	
		boolean flag1 = false, flag2 = false, flag3 = false;
		for(char a : password.toCharArray()) {
			if(Character.isDigit(a)) flag1 = true;
			if(Character.isUpperCase(a)) flag2 = true;
			if(Character.isLowerCase(a)) flag3 = true;
		}
		if(password.length() < 6 || !flag1 || !flag2 || !flag3) {
			throw new IllegalArgumentException("Invalid password");
		}
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Set<Game> getGames() {
		return games;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}

}
