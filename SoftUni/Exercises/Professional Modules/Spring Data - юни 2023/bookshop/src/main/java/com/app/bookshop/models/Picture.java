package com.app.bookshop.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String title;

	@Column
	private String caption;
	
	@Column
	private String path;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable( name = "pictures_albumes",
				joinColumns = @JoinColumn(name = "picture_ic"),
				inverseJoinColumns = @JoinColumn(name = "album_id")
	)
	private Set<Album> albums;
	
	public Picture(String title, String caption, String path, Set<Album> albums) {
		this.title = title;
		this.caption = caption;
		this.path = path;
		this.albums = albums;
	}
	
	public Picture() {}

}
