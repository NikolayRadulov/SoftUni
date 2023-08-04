package softuni.exam.models.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;

public class ImportPartDto {

	@Expose
	@NotNull
	@Size(min = 2, max = 19)
	private String partName;
	
	@DecimalMin("10.0")
	@DecimalMax("2000.0")
	@Expose
	@NotNull
	private double price;
	
	@Expose
	@Positive
	@NotNull
	private int quantity;
	
	public ImportPartDto() {
		// TODO Auto-generated constructor stub
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
