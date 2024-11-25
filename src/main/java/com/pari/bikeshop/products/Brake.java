package com.pari.bikeshop.products;

public class Brake extends Product {
	
	private String brakeType;
	

	public Brake(int productId, int brakeId, String nameModel, String company, double price, int amount, String brakeType) {
		super(productId, nameModel, company, price, amount, null, 0.0);
		this.brakeType = brakeType;
	}
	
	//allows you to create a Brake object without initializing any of its fields immediately. 
	//The super() call ensures that the no-argument constructor of the Product class is called.
	
	public Brake() {
		super();
	}

	public String getBrakeType() {
		return brakeType;
	}
	
	public void setBrakeType(String brakeType) {
		this.brakeType = brakeType;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Brake Type: " + brakeType;
	}

	public int getBrakeId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
