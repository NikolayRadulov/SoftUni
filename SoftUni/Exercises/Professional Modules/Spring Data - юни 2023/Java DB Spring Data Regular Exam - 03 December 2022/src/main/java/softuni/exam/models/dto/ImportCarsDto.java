package softuni.exam.models.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCarsDto {

	@XmlElement(name = "car")
	private List<ImportCarDto> cars;
	
	public ImportCarsDto() {
		// TODO Auto-generated constructor stub
	}

	public List<ImportCarDto> getCars() {
		return cars;
	}

	public void setCars(List<ImportCarDto> cars) {
		this.cars = cars;
	}

}
