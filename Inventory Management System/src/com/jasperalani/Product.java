package com.jasperalani;

import java.io.Serializable;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String name;
	int quantity;
	long price;
	int id;
	String category;
	
	public Product(String name, int quantity, long price, int id, String category) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.id = id;
		this.category = category;
	}
	
	public Object getItemAtPos(int i) {
		switch (i) {
			case 0:
				return this.name;
			case 1:
				return this.quantity;
			case 2:
				return this.price;
			case 3:
				return this.id;
			case 4:
				return this.category;
			default:
				return this.name;
			
		}
			
	}
	
	public String getProductAsString() {
		String product = this.name + ", " + String.valueOf(this.quantity) + ", " + String.valueOf(this.price) + ", " + String.valueOf(this.id) + ", " + category;
		return product;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public Long getPrice() {
		return this.price;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String category() {
		return this.category;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
}
