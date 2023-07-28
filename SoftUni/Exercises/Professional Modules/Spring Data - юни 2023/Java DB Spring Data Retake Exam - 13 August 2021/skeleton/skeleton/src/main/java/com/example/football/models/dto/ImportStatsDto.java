package com.example.football.models.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stats")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportStatsDto {

	@XmlElement(name = "stat")
	private List<ImportStatDto> dtos;
	
	public ImportStatsDto() {
		// TODO Auto-generated constructor stub
	}

	public List<ImportStatDto> getDtos() {
		return dtos;
	}

	public void setDtos(List<ImportStatDto> dtos) {
		this.dtos = dtos;
	}

}
