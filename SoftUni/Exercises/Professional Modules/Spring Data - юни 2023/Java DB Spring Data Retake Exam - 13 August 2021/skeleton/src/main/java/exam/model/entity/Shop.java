package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity{

	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private double income;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false, name = "employee_count")
	private int employeeCount;
	
	@Column(nullable = false, name = "shop_area")
	private int shopArea;
	
	@ManyToOne
	private Town town;
	
	
	public Shop(String name, double income, String address, int employeeCount, int shopArea) {
		this.name = name;
		this.income = income;
		this.address = address;
		this.employeeCount = employeeCount;
		this.shopArea = shopArea;
	}


	public Shop() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getIncome() {
		return income;
	}


	public void setIncome(double income) {
		this.income = income;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getEmployeeCount() {
		return employeeCount;
	}


	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}


	public int getShopArea() {
		return shopArea;
	}


	public void setShopArea(int shopArea) {
		this.shopArea = shopArea;
	}


	public Town getTown() {
		return town;
	}


	public void setTown(Town town) {
		this.town = town;
	}

}
