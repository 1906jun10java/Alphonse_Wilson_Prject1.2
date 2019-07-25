package com.revature.bean;

public class Owned {
	private int offer_id;
	private int userId;
	private int car_Id;
	private double offer_price;
	
	public Owned() {
		super();
	}

public Owned(int offer_id, int userId, int car_Id, double offer_price) {
	super();
	this.setOffer_id(offer_id);
	this.setUserId(userId);
	this.car_Id = car_Id;
	this.offer_price = offer_price;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getOffer_id() {
	return offer_id;
}

public void setOffer_id(int offer_id) {
	this.offer_id = offer_id;
}

public int getCar_Id() {
	return car_Id;
}

public void setCar_Id(int car_Id) {
	this.car_Id = car_Id;
}

public double getOffer_price() {
	return offer_price;
}

public void setOffer_price(double offer_price) {
	this.offer_price = offer_price;
}
}
