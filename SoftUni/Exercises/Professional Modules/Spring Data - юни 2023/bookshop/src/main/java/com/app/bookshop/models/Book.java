package com.app.bookshop.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.app.bookshop.models.enums.AgeRestriction;
import com.app.bookshop.models.enums.EditionType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private AgeRestriction age_restriction;
	
	@Column
	private int copies;
	
	@Column
	private String description;
	
	@Column
	private EditionType edition_type;
	
	@Column(precision = 2)
	private BigDecimal price;
	
	@Column
	private LocalDate release_date;
	
	@Column
	private String title;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "author_id")
	private Author author_id;
	
	@ManyToMany(mappedBy = "books", cascade = CascadeType.MERGE)
	private Set<Category> categories;
	
	
	
	public Book(String title, EditionType editionType, BigDecimal price, LocalDate releaseDate, AgeRestriction ageRestriction, Author author, Set<Category> categories, int copies) {
		this.title = title;
		this.edition_type = editionType;
		this.price = price;
		this.release_date = releaseDate;
		this.age_restriction = ageRestriction;
		this.author_id = author;
		this.copies = copies;
		this.categories = categories;
	}
	
	
	public Book() {}
	
	public long getId() {
		return id;
	}

}
