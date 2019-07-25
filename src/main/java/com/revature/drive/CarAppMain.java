package com.revature.drive;

import com.revature.bean.User;
import com.revature.menu.CustomerMenu;
import com.revature.menu.EmployeeMenu;
import com.revature.menu.Login;
import com.revature.menu.SignupMenu;

public class CarAppMain{

	public static void main(String[] args) {
		//turn methods for menus to return types
		CarApp();
		//employeeManagerApp();
		
	}
	public static void employeeManagerApp() {
		User user = new User();
		
		user.setType("Employee");
		user.setUser_FirstName("aaaa");
		user.setUser_FirstName("bbbb");
		user.setUser_Phone("6666");
		user.setUser_email("cccc");
		user.setUser_ManagerId(9999);
		user.setUser_pass("qqqq");
		user.setUser_email("eeee");
		
		SignupMenu newSignin = new SignupMenu();
		newSignin.signinNewUser(user);
		System.out.println("added new employee: "+ user.getUser_FirstName());
		
	}
	public static void CarApp() {
		//VariableCheck variables = new VariableCheck();
		
		boolean continueLoop = true;
	//	if(variables.getTravelTo() == null) {
	//		variables.setTravelTo("login");
	//	}
		Login login = new Login();
		User user = login.LoginPage();
		
	//	System.out.println(user.getUser()+"###########################");
		
		
		
		while(continueLoop == true) {
	//		System.out.println(variables.getTravelTo());
			if(user.getTravelTo().equals("login")) {
				Login newLogin = new Login();
				user = newLogin.LoginPage();
			}
			else if(user.getCustomer() == true) {
				CustomerMenu customer = new CustomerMenu();
				customer.LoginCustomer(user);
			}
			else if(user.getEmployee() == true) {
				EmployeeMenu employee = new EmployeeMenu();
				employee.LoginEmployee(user);
			}
			else if(user.getTravelTo().equals("signup")) {
				SignupMenu newSignin = new SignupMenu();
				newSignin.signinNewUser(user);
			}
			
		}
		
		
	}


}
