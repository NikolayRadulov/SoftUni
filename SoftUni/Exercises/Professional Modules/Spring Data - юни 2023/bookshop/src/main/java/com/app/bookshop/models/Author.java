package com.app.bookshop.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String first_name;
	
	@Column
	private String last_name;
	
	@OneToMany(mappedBy = "author_id", cascade = CascadeType.ALL)
	private Set<Book> books;
	
	public Author() {}
	
	public Author(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
	}
	


}
