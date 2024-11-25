package com.pari.bikeshop.products;

public class Drivetrain extends Product {
	
	private int amountOfGears;

	public Drivetrain(int drivetrainId, String nameModel, String company, double price, int amount, String description,
			double weight, int amountOfGears) {
		super(drivetrainId, nameModel, company, price, amount, description, weight);
		this.amountOfGears = amountOfGears;
	}

	public int getAmountOfGears() {
		return amountOfGears;
	}

	public void setAmountOfGears(int amountOfGears) {
		this.amountOfGears = amountOfGears;
	}

	@Override
	public String toString() {
		return super.toString() + ", amount of gears: " + amountOfGears; 
	}

	public int getDrivetrainId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
