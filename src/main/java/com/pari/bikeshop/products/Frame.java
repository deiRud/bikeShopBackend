package com.pari.bikeshop.products;

public class Frame extends Product {
	
	private String material;

	public Frame(int frameId, String nameModel, String company, double price, int amount, String description,
			double weight, String material) {
		super(frameId, nameModel, company, price, amount, description, weight);
		this.material = material;
	}

	public Frame() {
		super();
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	

	@Override
	public String toString() {
		return super.toString()+ ", material: " + material;	}

	public int getFrameId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
