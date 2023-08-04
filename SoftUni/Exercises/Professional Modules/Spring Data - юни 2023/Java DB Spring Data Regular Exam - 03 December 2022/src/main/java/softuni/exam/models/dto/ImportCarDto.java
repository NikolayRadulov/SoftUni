package softuni.exam.models.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCarDto {

	@NotNull
	@Size(min = 2, max = 30)
	@XmlElement(name = "carMake")
	private String carMake;

	@NotNull
	@Size(min = 2, max = 30)
	@XmlElement(name = "carModel")
	private String carModel;
	
	@NotNull
	@Positive
	@XmlElement(name = "year")
	private int year;
	
	@NotNull
	@Size(min = 2, max = 30)
	@XmlElement
	private String plateNumber;
	
	@NotNull
	@XmlElement(name = "kilometers")
	private int kilometers;
	
	@NotNull
	@DecimalMin("1.00")
	@XmlElement(name = "engine")
	private double engine;
	
	@NotNull
	@XmlElement(name = "carType")
	private String carType;
	
	public ImportCarDto() {
		// TODO Auto-generated constructor stub
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getKilometers() {
		return kilometers;
	}

	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}

	public double getEngine() {
		return engine;
	}

	public void setEngine(double engine) {
		this.engine = engine;
	}

	public @NotNull String getCarType() {
		return carType;
	}

	public void setCarType(@NotNull String carType) {
		this.carType = carType;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

}
