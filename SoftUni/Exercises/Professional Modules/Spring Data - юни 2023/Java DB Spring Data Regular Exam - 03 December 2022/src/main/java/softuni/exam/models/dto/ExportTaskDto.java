package softuni.exam.models.dto;

import java.math.BigDecimal;

public class ExportTaskDto {

	private String carsMake;
	private String carsModel;
	private String mechanicsFirstName;
	private String mechanicsLastName;
	private long id;
	private double engine;
	private BigDecimal price;


	
	public ExportTaskDto() {
		// TODO Auto-generated constructor stub
	}



	public String getCarsMake() {
		return carsMake;
	}



	public void setCarsMake(String carsMake) {
		this.carsMake = carsMake;
	}



	public String getCarsModel() {
		return carsModel;
	}



	public void setCarsModel(String carsModel) {
		this.carsModel = carsModel;
	}



	public String getMechanicsFirstName() {
		return mechanicsFirstName;
	}



	public void setMechanicsFirstName(String mechanicsFirstName) {
		this.mechanicsFirstName = mechanicsFirstName;
	}



	public String getMechanicsLastName() {
		return mechanicsLastName;
	}



	public void setMechanicsLastName(String mechanicsLastName) {
		this.mechanicsLastName = mechanicsLastName;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public double getEngine() {
		return engine;
	}



	public void setEngine(double engine) {
		this.engine = engine;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
