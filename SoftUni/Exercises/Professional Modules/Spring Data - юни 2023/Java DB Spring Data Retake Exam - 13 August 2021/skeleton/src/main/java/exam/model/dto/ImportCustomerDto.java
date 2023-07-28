package exam.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;

public class ImportCustomerDto {

	@NotNull
	@Size(min = 2)
	@Expose
	private String firstName;
	
	@NotNull
	@Size(min = 2)
	@Expose
	private String lastName;
	
	@Expose
	@Email
	@NotNull
	private String email;
	
	@Expose
	@NotNull
	private String registeredOn;
	
	@Expose
	@NotNull
	private TownJsonDto town;
	
	
	public ImportCustomerDto() {
		// TODO Auto-generated constructor stub
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRegisteredOn() {
		return registeredOn;
	}


	public void setRegisteredOn(String registeredOn) {
		this.registeredOn = registeredOn;
	}


	public TownJsonDto getTown() {
		return town;
	}


	public void setTown(TownJsonDto town) {
		this.town = town;
	}

}
