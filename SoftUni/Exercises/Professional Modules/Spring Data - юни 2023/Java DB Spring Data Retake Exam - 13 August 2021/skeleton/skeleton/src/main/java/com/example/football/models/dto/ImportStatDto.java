package com.example.football.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportStatDto {

	@NotNull
	@Positive
	@XmlElement(name = "passing")
	private float passing;
	
	@NotNull
	@Positive
	@XmlElement(name = "shooting")
	private float shooting;
	
	@NotNull
	@Positive
	@XmlElement(name = "endurance")
	private float endurance;
	
	public ImportStatDto() {
		// TODO Auto-generated constructor stub
	}

	public float getPassing() {
		return passing;
	}

	public void setPassing(float passing) {
		this.passing = passing;
	}

	public float getShooting() {
		return shooting;
	}

	public void setShooting(float shooting) {
		this.shooting = shooting;
	}

	public float getEndurance() {
		return endurance;
	}

	public void setEndurance(float endurance) {
		this.endurance = endurance;
	}

}
