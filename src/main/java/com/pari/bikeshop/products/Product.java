package com.pari.bikeshop.products;

import com.google.gson.annotations.SerializedName;

public abstract class Product  {
	private int productId;
    private String nameModel;
    private String company;
    private double price;
    private int amount;
	@SerializedName("product_description")
    private String description;
    private double weight;
	private String imageUrl;

	public Product(int productId, String nameModel, String company, double price, int amount, String description, double weight, String imageUrl) {
		this.productId = productId;
		this.nameModel = nameModel;
		this.company = company;
		this.price = price;
		this.amount = amount;
		this.description = description;
		this.weight = weight;
		this.imageUrl = imageUrl;
	}
	
	public Product() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getNameModel() {
		return nameModel;
	}

	public void setNameModel(String nameModel) {
		this.nameModel = nameModel;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", nameModel=" + nameModel + ", company=" + company + ", price=" + price + ", amount=" + amount + ", description=" + description + ", weight=" + weight + ", imageUrl=" + imageUrl + "]";
	}
}
