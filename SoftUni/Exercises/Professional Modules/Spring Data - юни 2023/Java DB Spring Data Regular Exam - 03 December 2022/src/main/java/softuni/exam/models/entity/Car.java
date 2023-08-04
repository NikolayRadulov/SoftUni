package softuni.exam.models.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import softuni.exam.util.enums.CarType;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "car_type")
	private CarType carType;
	
	@Column(nullable = false, name = "car_make")
	private String carMake;
	
	@Column(nullable = false, name = "car_model")
	private String carModel;
	
	@Column(nullable = false)
	private int year;
	
	@Column(unique = true, nullable = false, name = "plate_number")
	private String plateNumber;
	
	@Column(nullable = false)
	private int kilometers;
	
	@Column(nullable = false)
	private double engine;

	@OneToMany(mappedBy = "car")
	private Set<Task> tasks;
	
	public Car(CarType carType, String carMake, String carModel, int year, String plateNumber, int kilometers,
			double engine) {
		this.carType = carType;
		this.carMake = carMake;
		this.carModel = carModel;
		this.year = year;
		this.plateNumber = plateNumber;
		this.kilometers = kilometers;
		this.engine = engine;
	}



	public Car() {
		// TODO Auto-generated constructor stub
	}



	public CarType getCarType() {
		return carType;
	}



	public void setCarType(CarType carType) {
		this.carType = carType;
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



	public String getPlateNumber() {
		return plateNumber;
	}



	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
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

}
