package com.binsin.store.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	private int id;
	private String name;
	private String category;
	private int price;
	private String manufacturer;
	private int unitInStock;
	private String description;
}
