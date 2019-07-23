package com.binsin.store.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartItem implements Serializable {
	
	private static final long serialVersionUID = -5704274627532508394L;

	private int id;
	
	private Cart cart;
	
	private Product product;
	
	private int guantity;
	
	private double totalPrice;
	
}
