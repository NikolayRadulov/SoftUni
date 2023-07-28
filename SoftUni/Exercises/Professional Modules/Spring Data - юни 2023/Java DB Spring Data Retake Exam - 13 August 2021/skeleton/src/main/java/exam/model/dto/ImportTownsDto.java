package exam.model.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTownsDto {

	@XmlElement(name = "town")
	private List<ImportTownDto> dtos;
	
	
	public ImportTownsDto() {
		// TODO Auto-generated constructor stub
	}


	public List<ImportTownDto> getDtos() {
		return dtos;
	}


	public void setDtos(List<ImportTownDto> dtos) {
		this.dtos = dtos;
	}

}
