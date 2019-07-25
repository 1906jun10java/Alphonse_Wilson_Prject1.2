package com.revature.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bean.CustomerFunctions;
import com.revature.bean.User;
import com.revature.bean.VariableCheck;
import com.revature.util.ConnFactory;

public class CustomerMenu{

	public User LoginCustomer(User user) {
		VariableCheck variables = new VariableCheck();
		CustomerFunctions customer = new CustomerFunctions();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		variables.setLoop(true);
		//variables.setLogin(false);
		String selectionMenu = (""
				+ "1. View Profile"
				+ "\n2. Update Profile"
				+ "\n3. Make reimbursement request"
				+ "\n4. View reimbursement request(s)   "
				+ "\n5. Exit");
		
		while(variables.getLoop() == true) {
			try {
				customer.setProfile(user);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				System.out.println(selectionMenu);
				while(!sc.hasNextInt()) {
					System.out.println("Invalid input try again"+selectionMenu);
					sc.next();
				}
				
					variables.setMenuOption( sc.nextInt());
				
				
				switch (variables.getMenuOption()) {
		        case 1:
		        	try {
						customer.viewProfile(user);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            break;
		        case 2:
		        	try {
						customer.UpdateProfile(user);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            break;
		        case 3:
		        	try {
						customer.requestReimbursement(user);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//		        	System.out.println(user.getUser_FirstName()+
//		        			user.getUser_LastName()+
//		        			user.getUser_email()+
//		        			user.getUser_Phone()+
//		        			user.getUser_id()+
//		        			user.getUser_ManagerId()+
//		        			user.getUser_position()+
//		        			user.getUser_pass());
		        	break;
		        case 4:
		        	try {
						customer.ViewReimbursements(user);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            break;
		        case 5:
		        	customer.Exit(user, variables);
		            break;
		        default: 
		        	customer.ResetUserValues(user, variables);
		    }
				
				System.out.println("Username: "+user.getUser()+
						"\nCar: "+variables.getCarNumber()+" Offer: "+variables.getOffer()
						+"\nMenu: "+variables.getMenuOption());
			
			
		}
		return user;
	}

}
