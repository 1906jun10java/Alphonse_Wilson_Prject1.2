package com.revature.bean;

public class NewUser {

	private boolean loop;
	private int menuOption;
	private String userName;
	private String password;
	private boolean confirmPassword;
	private String firstName; 
	private String LastName;
	private boolean employee;
	private boolean customer; 
	public String phone;
	public String email;
	private int managerId;

	public boolean getLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public int getMenuOption() {
		return menuOption;
	}

	public void setMenuOption(int menuOption) {
		this.menuOption = menuOption;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(boolean confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public boolean getEmployee() {
		return employee;
	}

	public void setEmployee(boolean employee) {
		this.employee = employee;
	}

	public boolean getCustomer() {
		return customer;
	}

	public void setCustomer(boolean customer) {
		this.customer = customer;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	
}
