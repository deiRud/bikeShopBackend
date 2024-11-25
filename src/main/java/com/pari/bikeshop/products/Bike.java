package com.pari.bikeshop.products;

public class Bike extends Product {
	
	private int bikeId;
	private String nameModel;
	private String company;
	private double price;
	private int amount;
	private String description;
	private double weight;
	private Frame frame;
	private Wheelset frontWheelset;
	private Wheelset rearWheelset;
	private Drivetrain drivetrain;
	private Brake brake;
	
	
	/*public Bike(Frame frame, Wheelset frontWheelset, Wheelset rearWheelset, Drivetrain drivetrain, Brake brake) {
		super();
		this.frame = frame;
		this.frontWheelset = frontWheelset;
		this.rearWheelset = rearWheelset;
		this.drivetrain = drivetrain;
		this.brake = brake;
	}*/

	public Bike(int bikeId, String nameModel, String company, double price, int amount, String description, double weight) {
		super(bikeId, nameModel, company, price, amount, null, 0.0);
	}

	
	public Bike() {
		super();
	}

	public int getBikeId() {
		return bikeId;
	}
	
	public String getNameModel() {
		return nameModel;
	}
	
	public String getCompany() {
		return company;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getWeight() {
		return weight;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public Wheelset getFrontWheelset() {
		return frontWheelset;
	}

	public void setFrontWheelset(Wheelset frontWheelset) {
		this.frontWheelset = frontWheelset;
	}

	public Wheelset getRearWheelset() {
		return rearWheelset;
	}

	public void setRearWheelset(Wheelset rearWheelset) {
		this.rearWheelset = rearWheelset;
	}

	public Drivetrain getDrivetrain() {
		return drivetrain;
	}

	public void setDrivetrain(Drivetrain drivetrain) {
		this.drivetrain = drivetrain;
	}

	public Brake getBrake() {
		return brake;
	}

	public void setBrake(Brake brake) {
		this.brake = brake;
	}
	
	public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

	@Override
	public String toString() {
		return "Bike [frame=" + frame + ", frontWheelset" + frontWheelset + rearWheelset + ", rearWheelset" + ", drivetrain=" + drivetrain + ", brake=" + brake
				+ "]";
	}


}
