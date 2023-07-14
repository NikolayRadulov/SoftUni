package com.gameshop.app.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart extends BaseEntity{

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name = "shopping_carts_games",
			joinColumns = @JoinColumn(name = "cart_id"),
			inverseJoinColumns = @JoinColumn(name = "game_id")
			)
	private Set<Game> gamesInCart;
	
	@OneToOne(mappedBy = "shoppingCart")
	private User owner;
	
	public ShoppingCart(Set<Game> gamesInCart, User owner) {
		super();
		this.gamesInCart = gamesInCart;
		this.owner = owner;
	}

	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

}
