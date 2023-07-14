package com.gameshop.app.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	
	@ManyToOne
	private User owner;
	
	@ManyToMany
	private Set<Game> products;
	
	public Order(User owner, Set<Game> products) {
		this.owner = owner;
		this.products = products;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

}
