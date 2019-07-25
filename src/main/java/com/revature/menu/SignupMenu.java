package com.revature.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bean.NewUser;
import com.revature.bean.SignupFunctions;
import com.revature.bean.User;


public class SignupMenu{
	public User signinNewUser(User user) {
		NewUser newUser = new NewUser();
		SignupFunctions signin = new SignupFunctions();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		newUser.setLoop(true);
		//variables.setLogin(false);
		String selectionMenu = (""
				+ "1. Enter a new username, password, name, ect."
				+ "\n2. Save & exit"
				+ "\n3. Exit");
		while(newUser.getLoop() == true) {
				
				System.out.println(selectionMenu);
				while(!sc.hasNextInt()) {
					System.out.println("Invalid input try again"+selectionMenu);
					sc.next();
				}
				
				newUser.setMenuOption( sc.nextInt());
				
				
				switch (newUser.getMenuOption()) {
		        case 1:
		        	try {
						signin.User(newUser);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

		        	signin.Password(newUser);

		        	signin.NewPassword(newUser);

		        	signin.FirstName(newUser);

		        	signin.LastName(newUser);

		        	signin.userType(newUser);
		        	
		        	signin.phone(newUser);

		        	signin.email(newUser);
		        	try {
						signin.managerId(newUser);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        	break;
		        	
		        	
		        case 2:
		        	try {
						signin.Save(user, newUser);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            break;
		        case 3:
		        	signin.Exit(user, newUser);
		            
		        default: 
		        	System.out.println("You did not choose one of the selections");
		        	
		    }
				
				System.out.println(""
						+"\nUsername: "+newUser.getUserName()
						+"\n Password: "+newUser.getPassword()
						+"\nPassword confirmed: "+newUser.getConfirmPassword()
						+"\nFirst name: "+newUser.getFirstName()
						+"\nLast name: "+newUser.getLastName());
		}
		return user;
	}

}