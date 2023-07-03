package com.app.bookshop.models;

import java.time.LocalDateTime;
import java.util.Set;

import com.app.bookshop.models.annotations.Password;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(nullable = false)
	@Size(min = 4, max = 30)
	private String username;
	
	@Column(nullable = false)
	@Password(minLength = 6, 
			  maxLength = 50, 
			  containsDigit = true, 
			  containsLowerCase = false)
	private String password;
	
	@Column
	@Email(regexp = "[A-z]+[-_.]*[A-z]+@[A-z]+[-_.]*[A-z]+\\.[A-z]+")
	private String email;
	
	@Column
	private LocalDateTime registered_on;
	
	@Column(name = "last_time_logged_in")
	private LocalDateTime lastTimeLoggedIn; 
	
	@Column(nullable = false)
	@Min(1)
	@Max(120)
	private int age;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "born_town_id")
	private Town bornInTown;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "current_town_id")
	private Town currentlyLivingInTown;
	
	@OneToMany(mappedBy = "owner",cascade = CascadeType.MERGE)
	private Set<Album> albums;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	public User(String firstName, String lastName, @Size(min = 4, max = 30) String username, String password,
			@Email(regexp = "[A-z]+[-_.]*[A-z]+@[A-z]+[-_.]*[A-z]+\\.[A-z]+") String email, LocalDateTime registered_on,
			LocalDateTime last_time_logged_in, @Min(1) @Max(120) int age, Town bornInTown, Town currentlyLivingInTown,
			Set<Album> albums) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.registered_on = registered_on;
		this.lastTimeLoggedIn = last_time_logged_in;
		this.age = age;
		this.bornInTown = bornInTown;
		this.currentlyLivingInTown = currentlyLivingInTown;
		this.albums = albums;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", email=" + email + ", registered_on=" + registered_on + ", last_time_logged_in="
				+ lastTimeLoggedIn + ", age=" + age + ", bornInTown=" + bornInTown + ", currentlyLivingInTown="
				+ currentlyLivingInTown + ", albums=" + albums + "]";
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public LocalDateTime getLastTimeLoggedIn() {
		return lastTimeLoggedIn;
	}

}
