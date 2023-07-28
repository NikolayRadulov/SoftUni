package exam.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportShopDto {
	
	@Size(min = 4)
	@NotNull
	@XmlElement
	private String address;
	
	@XmlElement(name = "employee-count")
	@Min(1)
	@Max(50)
	@NotNull
	private int employeeCount;
	
	@Min(20000)
	@XmlElement
	@NotNull
	private double income;
	
	@Size(min = 4)
	@NotNull
	@XmlElement
	private String name;
	
	@Min(150)
	@NotNull
	@XmlElement(name = "shop-area")
	private int shopArea;
	
	@XmlElement
	@NotNull
	private ImportTownDto town;
	
	public ImportShopDto() {
		// TODO Auto-generated constructor stub
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

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getShopArea() {
		return shopArea;
	}

	public void setShopArea(int shopArea) {
		this.shopArea = shopArea;
	}

	public ImportTownDto getTown() {
		return town;
	}

	public void setTown(ImportTownDto town) {
		this.town = town;
	}

}
