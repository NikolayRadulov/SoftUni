package exam.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import exam.model.entity.enums.WarrantyType;

@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity {

	@Column(nullable = false, name = "mac_address", unique = true)
	private String macAddress;
	
	@Column(nullable = false, name = "cpu_speed")
	private float cpuSpeed;
	
	@Column(nullable = false)
	private int ram;
	
	@Column(nullable = false)
	private int storage;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@Column(nullable = false)
	private BigDecimal price;
	
	@Enumerated
	@Column(nullable = false, name = "warranty_type")
	private WarrantyType warrantyType;
	
	@ManyToOne
	private Shop shop;
	
	public Laptop(String macAddress, float cpuSpeed, int ram, int storage, String description, BigDecimal price,
			WarrantyType warrantyType, Shop shop) {
		this.macAddress = macAddress;
		this.cpuSpeed = cpuSpeed;
		this.ram = ram;
		this.storage = storage;
		this.description = description;
		this.price = price;
		this.warrantyType = warrantyType;
		this.shop = shop;
	}

	public Laptop() {
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public WarrantyType getWarrantyType() {
		return warrantyType;
	}

	public void setWarrantyType(WarrantyType warrantyType) {
		this.warrantyType = warrantyType;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

}
