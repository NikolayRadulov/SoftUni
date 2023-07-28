package exam.model.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportShopsDto {

	@XmlElement(name = "shop")
	private List<ImportShopDto> dtos;
	
	public ImportShopsDto() {
		// TODO Auto-generated constructor stub
	}

	public List<ImportShopDto> getDtos() {
		return dtos;
	}

	public void setDtos(List<ImportShopDto> dtos) {
		this.dtos = dtos;
	}

}
