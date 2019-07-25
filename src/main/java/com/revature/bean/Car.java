package com.revature.bean;

public class Car {
	private int carID;
	private int yearManufactured;
	private String make;
	private String model;
	
	// best practices: explicitly declare a noargs constructor when
	// any constructor is present, we are not provided the default constructor
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(int carID, int yearManufactured, String make, String model) {
		super();
		this.carID = carID;
		this.yearManufactured = yearManufactured;
		this.make = make;
		this.model = model;
	}

	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public int getYearManufactured() {
		return yearManufactured;
	}

	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
