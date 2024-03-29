package softuni.exam.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;

public class ImportMechanicsDto {

	@Expose
	@Email
	@NotNull
	private String email;
	
	@Expose
	@Size(min = 2)
	@NotNull
	private String firstName;
	
	@Expose
	@Size(min = 2)
	@NotNull
	private String lastName;
	
	@Expose
	@Size(min=2)
	private String phone;
	
	public ImportMechanicsDto() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
