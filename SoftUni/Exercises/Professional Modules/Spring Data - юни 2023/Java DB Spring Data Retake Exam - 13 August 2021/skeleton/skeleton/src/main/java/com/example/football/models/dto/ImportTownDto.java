package com.example.football.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;

public class ImportTownDto {

	@NotNull
	@Expose
	@Size(min = 2)
	private String name;
	
	@NotNull
	@Expose
	@Positive
	private int population;
	
	@NotNull
	@Expose
	@Size(min = 10)
	private String travelGuide;
	
	public ImportTownDto() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getTravelGuide() {
		return travelGuide;
	}

	public void setTravelGuide(String travelGuide) {
		this.travelGuide = travelGuide;
	}

}
