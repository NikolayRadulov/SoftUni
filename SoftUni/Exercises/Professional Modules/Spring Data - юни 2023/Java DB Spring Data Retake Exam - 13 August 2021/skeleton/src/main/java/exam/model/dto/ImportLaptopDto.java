package exam.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;

import exam.model.entity.enums.WarrantyType;

public class ImportLaptopDto {

	@Size(min = 8)
	@Expose
	@NotNull
	private String macAddress;
	
	@Positive
	@Expose
	@NotNull
	private float cpuSpeed;
	
	@Min(8)
	@Max(128)
	@Expose
	@NotNull
	private int ram;
	
	@Min(128)
	@Max(1024)
	@Expose
	@NotNull
	private int storage;
	
	@Size(min = 10)
	@Expose
	@NotNull
	private String description;
	
	@Positive
	@Expose
	@NotNull
	private double price;
	
	@Expose
	@NotNull
	private WarrantyType warrantyType;
	
	@Expose
	@NotNull
	private ShopJsonDto shop;
	
	
	public ImportLaptopDto() {
		// TODO Auto-generated constructor stub
	}


	public String getMacAddress() {
		return macAddress;
	}


	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}


	public float getCpuSpeed() {
		return cpuSpeed;
	}


	public void setCpuSpeed(float cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}


	public int getRam() {
		return ram;
	}


	public void setRam(int ram) {
		this.ram = ram;
	}


	public int getStorage() {
		return storage;
	}


	public void setStorage(int storage) {
		this.storage = storage;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public WarrantyType getWarrantyType() {
		return warrantyType;
	}


	public void setWarrantyType(WarrantyType warrantyType) {
		this.warrantyType = warrantyType;
	}


	public ShopJsonDto getShop() {
		return shop;
	}


	public void setShop(ShopJsonDto shop) {
		this.shop = shop;
	}

}
