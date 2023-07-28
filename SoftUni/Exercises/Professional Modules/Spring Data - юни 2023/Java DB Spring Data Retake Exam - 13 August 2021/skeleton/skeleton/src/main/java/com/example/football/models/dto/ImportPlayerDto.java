package com.example.football.models.dto;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPlayerDto {

	@Size(min = 2)
	@NotNull
	@XmlElement(name = "first-name")
	private String firstName;
	
	@Size(min = 2)
	@NotNull
	@XmlElement(name = "last-name")
	private String lastName;
	
	@XmlElement
	@Email
	@NotNull
	private String email;
	
	@NotNull
	@XmlElement(name = "birth-date")
	private String birthDate;
	
	@NotNull
	@XmlElement
	private String position;
	
	@XmlElement(name = "town")
	@NotNull
	private TownBase townBase;
	
	@XmlElement(name = "team")
	@NotNull
	private TeamBase teamBase;
	
	@XmlElement(name = "stat")
	@NotNull
	private StatBase statBase;
	
	
	public ImportPlayerDto() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public TownBase getTownBase() {
		return townBase;
	}

	public void setTownBase(TownBase townBase) {
		this.townBase = townBase;
	}

	public TeamBase getTeamBase() {
		return teamBase;
	}

	public void setTeamBase(TeamBase teamBase) {
		this.teamBase = teamBase;
	}

	public StatBase getStatBase() {
		return statBase;
	}

	public void setStatBase(StatBase statBase) {
		this.statBase = statBase;
	}

}
