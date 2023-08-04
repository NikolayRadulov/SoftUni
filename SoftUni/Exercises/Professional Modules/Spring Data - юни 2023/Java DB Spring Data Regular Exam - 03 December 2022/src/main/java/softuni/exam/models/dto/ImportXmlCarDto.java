package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportXmlCarDto {

	@XmlElement(name = "id")
	private long id;
	
	public ImportXmlCarDto() {
		// TODO Auto-generated constructor stub
	}

}
