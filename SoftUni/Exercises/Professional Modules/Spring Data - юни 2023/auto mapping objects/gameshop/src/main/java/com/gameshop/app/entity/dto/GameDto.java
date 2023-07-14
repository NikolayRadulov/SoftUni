package com.gameshop.app.entity.dto;

import java.time.LocalDate;

public class GameDto {

	private String title;
	private double price;
	private String description;
	private LocalDate releaseDate;
	
	public GameDto() {
		// TODO Auto-generated constructor stub
	}

	public String getInfo() {
		return title + " " + price;
	}
	
	public String getDetailedInfo() {
		return String.format("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s%n", title, price, description, String.valueOf(releaseDate));
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
