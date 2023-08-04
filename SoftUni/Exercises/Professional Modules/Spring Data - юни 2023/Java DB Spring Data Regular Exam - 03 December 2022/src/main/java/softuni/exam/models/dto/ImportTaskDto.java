package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTaskDto {

	
	@XmlElement
	@NotNull
	private String date;
	
	@XmlElement
	@NotNull
	@Positive
	private double price;
	
	@XmlElement
	@NotNull
	private CarBaseDto car;
	
	@XmlElement
	@NotNull
	private ImportXmlMechanicDto mechanic;
	
	@XmlElement
	@NotNull
	private ImportXmlPartDto part;
	
	
	public ImportTaskDto() {
		// TODO Auto-generated constructor stub
	}


	public @NotNull String getDate() {
		return date;
	}


	public void setDate(@NotNull String date) {
		this.date = date;
	}


	public @NotNull double getPrice() {
		return price;
	}


	public void setPrice(@NotNull double price) {
		this.price = price;
	}


	public @NotNull CarBaseDto getCar() {
		return car;
	}


	public void setCar(@NotNull CarBaseDto car) {
		this.car = car;
	}


	public ImportXmlMechanicDto getMechanic() {
		return mechanic;
	}


	public void setMechanic(ImportXmlMechanicDto mechanic) {
		this.mechanic = mechanic;
	}


	public ImportXmlPartDto getPart() {
		return part;
	}


	public void setPart(ImportXmlPartDto part) {
		this.part = part;
	}

}
