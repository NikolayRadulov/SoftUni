package exam.model.dto;

import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;

public class ShopJsonDto {

	@Expose
	@NotNull
	private String name;
	
	public ShopJsonDto() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
