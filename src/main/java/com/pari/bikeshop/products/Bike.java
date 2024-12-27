package com.pari.bikeshop.products;
import com.google.gson.annotations.SerializedName;
import com.pari.bikeshop.products.Color;

public class Bike extends Product {

	private String brand;
	private String model;
	@SerializedName("bike_description")
	private String description;
	private Color[] colors;

	public Bike(int productId, String nameModel, String company, double price, int amount, String description, double weight, String imageUrl, String brand, String model, Color[] colors) {
		super(productId, nameModel, company, price, amount, description, weight, imageUrl);
		this.brand = brand;
		this.model = model;
		this.description = description;
		this.colors = colors;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Color[] getColors() {
		return colors;
	}

	public void setColors(Color[] colors) {
		this.colors = colors;
	}
}
