package com.example.football.models.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPlayersDto {

	@XmlElement(name = "player")
	private List<ImportPlayerDto> dtos;
	
	public ImportPlayersDto() {
		// TODO Auto-generated constructor stub
	}

	public List<ImportPlayerDto> getDtos() {
		return dtos;
	}

	public void setDtos(List<ImportPlayerDto> dtos) {
		this.dtos = dtos;
	}

}
