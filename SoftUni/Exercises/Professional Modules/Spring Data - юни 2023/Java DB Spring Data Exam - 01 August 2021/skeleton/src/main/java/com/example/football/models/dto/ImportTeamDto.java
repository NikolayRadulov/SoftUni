package com.example.football.models.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;

public class ImportTeamDto {

	@NotNull
	@Size(min = 3)
	@Expose
	private String name;
	
	@NotNull
	@Size(min = 3)
	@Expose
	private String stadiumName;
	
	@NotNull
	@Expose
	@Min(1000)
	private int fanBase;
	
	@NotNull
	@Size(min = 10)
	@Expose
	private String history;
	
	@NotNull
	@Expose
	private String townName;
	
	public ImportTeamDto() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String studiumName) {
		this.stadiumName = studiumName;
	}

	public int getFanBase() {
		return fanBase;
	}

	public void setFanBase(int fanBase) {
		this.fanBase = fanBase;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

}
