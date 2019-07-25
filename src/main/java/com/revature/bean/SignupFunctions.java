package com.revature.bean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.bean.NewUser;
import com.revature.bean.User;
import com.revature.util.ConnFactory;
public class SignupFunctions {
	public static ConnFactory cf= ConnFactory.getInstance();
	public static Connection conn = cf.getConnection();
	public void User(NewUser newUser) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("User:  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nUser: ");
			sc.next();
		}
    	newUser.setUserName(sc.next());
    	
    	System.out.println();
    	 
//    	Connection conn = ConnFactory.getConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS;");//WHERE user_name = '"+newUser.getUserName()+"'
//		ResultSetMetaData rsmd = rs.getMetaData();
//		int columnsNumber = rsmd.getColumnCount();
//		String colName;
//		
//		
//		while (rs.next()) {
//			for (int i = 1; i <= columnsNumber; i++) {
//				colName = rsmd.getColumnName(i);
//				System.out.print(colName+" ["+rs.getString(i) + "] ");
//			}
//			System.out.println();
//			
//		}
		
    //	SELECT user_name FROM USERS WHERE user_name = 'ooo';
    	
    	
		//System.out.println(stmt.getResultSet()+"found it ****************");
		//rs.getString(i);
    	
	}
	
	public void Password(NewUser newUser) {
		
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("Password:  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nPassword: ");
			sc.next();
		}
    	newUser.setPassword(sc.next());
    	
    	System.out.println();
	}
	public void userType(NewUser newUser) {
		String secret = null;
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("is manager(1) or employee(2)");
    	
    	while(!sc.hasNextInt()) {
			System.out.println("Invalid input try again\nPassword: ");
			sc.next();
		}
    	int custEmp = sc.nextInt();
    	if(custEmp == 1) {
    		newUser.setEmployee(true);
    		newUser.setCustomer(false);
    	}
    	else if(custEmp == 2) {
    		newUser.setCustomer(true);
    		newUser.setEmployee(false);
    	}
    	else {
    		System.out.println("That was not one of the options");
    	}
    	
    	System.out.println();
	}
	public void NewPassword(NewUser newUser) {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Confirm password:  ");
			String confirm = sc.next();
			if(confirm.equals(newUser.getPassword())) {
				newUser.setConfirmPassword(true);
				System.out.println("Password confirmed");
			}
			
		}catch(Exception e) {
			System.out.println("Invalid input try again");
			
		}finally{
			System.out.println();
		}
    	
	}
	public void FirstName(NewUser newUser) {
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("First name:  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nFirst name: ");
			sc.next();
		}
    	newUser.setFirstName(sc.next());
    	
    	System.out.println();
		
	}
	public void LastName(NewUser newUser) {
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("Last name:  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nLast name: ");
			sc.next();
		}
    	newUser.setLastName(sc.next());
    	
    	System.out.println();
		
	}
	public void phone(NewUser newUser) {
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("Phone Number:  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nLast name: ");
			sc.next();
		}
    	newUser.setPhone(sc.next());
    	
    	System.out.println();
		
	}
	public void email(NewUser newUser) {
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("Email address:  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nLast name: ");
			sc.next();
		}
    	newUser.setEmail(sc.next());
    	
    	System.out.println();
		
	}
	public void managerId(NewUser newUser) throws SQLException {



			String sql = "SELECT EMPID, username FROM USERS WHERE POSITION = 'Manager'";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String user_name = rs.getString("username");
				int user_id = rs.getInt("EMPID");
				System.out.println("Manager ID: ["+user_id+"] Name: "+user_name);
			}	
	
		
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("Manager of employee (select by id):  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nLast name: ");
			sc.next();
		}
    	newUser.setManagerId(sc.nextInt());
    	
    	System.out.println();
		
	}
		
	public void Save(User user, NewUser newUser) throws SQLException {
		if((newUser.getConfirmPassword() == true) 
			&& (newUser.getUserName() != null)
			&& (newUser.getFirstName() != null)
			&& (newUser.getLastName() != null)) {
			
			System.out.println("Saved");
			newUser.setLoop(false);
			user.setTravelTo("login");
			// save the data into the sql user sql tables
			
		}
		else {
			System.out.println("you did not fill out the menu \nwith the required feilds");
		}

		Statement stmt = conn.createStatement();
		String custemp;
		if(newUser.getCustomer() == true) {
			 custemp = "Employee";
			
		}
		else if(newUser.getEmployee() == true) {
			 custemp = "Manager";
		}
		else {
			 custemp = "none";

		}
		//stmt.executeQuery("INSERT INTO USERS(USER_NAME, USER_PASS, USER_TYPE) VALUES('"+newUser.getUserName()+"','"+newUser.getPassword()+"','"+custemp+"')");

		stmt.executeQuery("INSERT INTO USERS (position, firstname, lastname, phone, email, mymanager, pass, username) "
				+ "VALUES ('"+custemp+"', '"+newUser.getFirstName()+"','"+newUser.getLastName()+"', '"+newUser.getPhone()+"', '"+newUser.getEmail()+"', "+newUser.getManagerId()+", '"+newUser.getPassword()+"', '"+newUser.getUserName()+"')");

																															  									

	}
	
	public void Exit(User user, NewUser newUser) {
		System.out.println("Exiting siginup menu");
		newUser.setLoop(false);
		user.setTravelTo("login");
		
	}

	
	
	

	

	

	

		
	
}
