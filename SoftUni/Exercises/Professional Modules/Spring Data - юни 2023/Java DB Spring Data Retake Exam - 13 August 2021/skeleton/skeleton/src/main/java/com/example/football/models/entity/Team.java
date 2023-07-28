package com.example.football.models.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

	@Column(unique = true, nullable = false)
	private String name;
	
	@Column(name = "studium_name", nullable = false)
	private String stadiumName;
	
	@Column(nullable = false, name = "fan_base")
	private String fanBase;
	
	@Column(nullable = false, name = "travel_guide", columnDefinition = "text")
	private String history;
	
	@ManyToOne
	private Town town;
	
	@OneToMany(mappedBy = "team")
	private Set<Player> players;
	
	public Team(String name, String stadiumName, String fanBase, String history) {
		this.name = name;
		this.stadiumName = stadiumName;
		this.fanBase = fanBase;
		this.history = history;
	}

	public Team() {
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

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getFanBase() {
		return fanBase;
	}

	public void setFanBase(String fanBase) {
		this.fanBase = fanBase;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

}
