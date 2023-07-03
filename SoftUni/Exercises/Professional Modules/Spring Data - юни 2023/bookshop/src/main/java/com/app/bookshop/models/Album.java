package com.app.bookshop.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "albumes")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column(name = "background_color")
	private String backgroundColor;
	
	@Column(name = "is_public")
	private boolean isPublic;
	
	@ManyToMany(mappedBy = "albums", cascade = CascadeType.MERGE)
	private Set<Picture> pictures;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private User owner;
	
	public Album(String name, String backgroundColor, boolean isPublic, Set<Picture> pictures, User owner) {
		this.name = name;
		this.backgroundColor = backgroundColor;
		this.isPublic = isPublic;
		this.pictures = pictures;
		this.owner = owner;
	}

	public Album() {
		// TODO Auto-generated constructor stub
	}

}
