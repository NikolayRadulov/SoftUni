package com.gameshop.app.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {

	@Column
	private String title;
	
	@Column
	private String trailer;
	
	@Column
	private String thumbnailPath;
	
	@Column
	private double size;
	
	@Column
	private double price;
	
	@Column
	private String description;
	
	@Column
	private LocalDate releaseDate;

	@ManyToMany(mappedBy = "games", cascade = CascadeType.MERGE)
	private Set<User> users;
	
	@ManyToMany(mappedBy = "gamesInCart", cascade = CascadeType.MERGE)
	private Set<ShoppingCart> carts;
	
	public Game(String title, double price, double size, String trailer, String thumbnailPath, String description, LocalDate releaseDate, 
			Set<User> users, Set<ShoppingCart> carts) {
		this.users = users;
		this.carts = carts;
		this.title = title;
		this.trailer = trailer;
		this.thumbnailPath = thumbnailPath;
		this.size = size;
		this.price = price;
		this.description = description;
		this.releaseDate = releaseDate;
		validate();
	}


	public void validate() {
		if(!Character.isUpperCase(title.charAt(0)) || title.length() < 3 || title.length() > 100) throw new IllegalArgumentException("Invalid title.");
		if(price < 0 || size < 0) throw new IllegalArgumentException("Price and size must be positive.");
		if(trailer.length() != 11) throw new IllegalArgumentException("Invalid trailer.");
		if(!thumbnailPath.startsWith("http://") && !thumbnailPath.startsWith("https://")) throw new IllegalArgumentException("Invalid thumbnail url.");
	 	if(description.length() < 20) throw new IllegalArgumentException("Description is too short.");
	}


	public Game() {
		// TODO Auto-generated constructor stub
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getTrailer() {
		return trailer;
	}


	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}


	public String getThumbnailPath() {
		return thumbnailPath;
	}


	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}


	public double getSize() {
		return size;
	}


	public void setSize(double d) {
		this.size = d;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

}
