package com.pari.bikeshop.products;

public class Wheelset extends Product {
	
	private String typeOfTires;

	public Wheelset(int wheelsetId, String nameModel, String company, double price, int amount, String description,
			double weight, String typeOfTires) {
		super(wheelsetId, nameModel, company, price, amount, description, weight);
		this.typeOfTires = typeOfTires;
	}

	public String getTypeOfTires() {
		return typeOfTires;
	}

	public void setTypeOfTires(String typeOfTires) {
		this.typeOfTires = typeOfTires;
	}

	@Override
	public String toString() {
		return super.toString() + ", types of tires:" + typeOfTires;
	}

	public int getWheelsetId() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
