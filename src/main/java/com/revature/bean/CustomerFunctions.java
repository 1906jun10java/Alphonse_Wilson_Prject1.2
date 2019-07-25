package com.revature.bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.bean.VariableCheck;
import com.revature.dao.UserDAOImpl;
import com.revature.util.ConnFactory;
public class CustomerFunctions {
	EmployeeFunctions ef = new EmployeeFunctions();
	UserDAOImpl userDao = new UserDAOImpl();
	public static ConnFactory cf= ConnFactory.getInstance();
	public static Connection conn = cf.getConnection();
	public void viewProfile(User user) throws SQLException {


	

			String sql = "SELECT * FROM USERS WHERE username = '"+user.getUser()+"' AND POSITION ='"+user.getUser_position()+"'";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int user_id = rs.getInt("EMPID");
				String user_position = rs.getString("POSITION");
				
				String user_FirstName = rs.getString("FIRSTNAME");
				String user_LastName = rs.getString("LASTNAME");
				String user_Phone = rs.getString("PHONE");
				
				String user_email = rs.getString("EMAIL");
				
				int user_ManagerId = rs.getInt("MYMANAGER");
				String user_name = rs.getString("username");
				String user_pass = rs.getString("PASS");
				System.out.println(" ID: "+user_id
								+" Username: "+user_name
								+" Password: "+user_pass
								+"\n First name: "+user_FirstName
								+" Last name: "+user_LastName
								+"\n Phone number: "+user_Phone
								+"\n Email: "+user_email
								+"\n Manager ID: "+user_ManagerId
								+" Employee Position: "+user_position);
			}	
			
		
	}
	
	public void setProfile(User user) throws SQLException {



			String sql = "SELECT * FROM USERS WHERE username = '"+user.getUser()+"' AND POSITION ='Employee'";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int user_id = rs.getInt("EMPID");
				String user_position = rs.getString("POSITION");
				
				String user_FirstName = rs.getString("FIRSTNAME");
				String user_LastName = rs.getString("LASTNAME");
				String user_Phone = rs.getString("PHONE");
				
				String user_email = rs.getString("EMAIL");
				
				int user_ManagerId = rs.getInt("MYMANAGER");
				String user_name = rs.getString("username");
				String user_pass = rs.getString("PASS");

				
				
				user.setUser_name(user_name);
				user.setUser_pass(user_pass);
				user.setUser_ManagerId(user_ManagerId);
				user.setUser_position(user_position);
				user.setUser_email(user_email);
				user.setUser_Phone(user_Phone);
				user.setUser_LastName(user_LastName);
				user.setUser_FirstName(user_FirstName);
				user.setUser_position(user_position);
				user.setUser_id(user_id);
			}	
	
		
	}
	
	public void UpdateProfile(User user) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		String updatedColumn = "";
		System.out.println("What would you like to update... \n first name(1), last name(2),\n username(3), password(4),\n phone number(5), email(6) ");
		
		while(!sc.hasNextInt()) {
			System.out.println("Invalid input try again");
			sc.next();
		}
		
		int selection = ( sc.nextInt());
		
		switch (selection) {
        case 1:
        	 updatedColumn = "FIRSTNAME";
        	break;
        case 2:
        	 updatedColumn = "LASTNAME";
        	break;
        case 3:
        	 updatedColumn = "username";
        	break;
        case 4:
        	 updatedColumn = "password";
        	break;
        case 5:
        	 updatedColumn = "PHONE";
        	break;
        case 6:
        	updatedColumn = "EMAIL";

        	break;
        default:
        	System.out.println("nothing selected");
		}
		
		System.out.println("What would you like to change the "+updatedColumn+" to: ");
		while(!sc.hasNext()) {
			System.out.println("Invalid input try again");
			sc.next();
		}
		
		String update = ( sc.next());
		
		
		String sql = "UPDATE USERS SET "+updatedColumn+" = '"+update+"' WHERE EMPID = "+user.getUser_id();

		

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate(sql);
			

		
	}

	

	

	
	public void ViewCarPaymentDetails() {
		//use sql to list the remaining payment for each of the owned cars
    	System.out.println("you own no money so far");
	}
	
	public void ResetUserValues(User user, VariableCheck variables) {
		user.setCustomer(false);
    	user.setEmployee(false);
    	user.setUser(null);
    	user.setPass(null);
    	variables.setLogin(false);
    	
    	
    	System.out.println("something went wrong."
    			+ " please enter your selected options correctly");
		
	}
	
	public void Exit(User user, VariableCheck variables) {
		System.out.println("Exiting");
    	variables.setLoop(false);
    	user.setTravelTo("login");
	}
	
	public void getPrfile(User user) throws SQLException {


		
			String sql = "SELECT * FROM USERS ";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int user_id = rs.getInt("EMPID");
				String user_position = rs.getString("POSITION");
				
				String user_FirstName = rs.getString("FIRSTNAME");
				String user_LastName = rs.getString("LASTNAME");
				String user_Phone = rs.getString("PHONE");
				
				String user_email = rs.getString("EMAIL");
				
				int user_ManagerId = rs.getInt("MYMANAGER");
				String user_name = rs.getString("username");
				String user_pass = rs.getString("PASS");
				user.setUser_id(user_id);
				System.out.println(user.getUser_id()+"#############");
				user.setUser_name(user_name);
				user.setUser_pass(user_pass);
				user.setUser_FirstName(user_FirstName);
				user.setUser_LastName(user_LastName);
				user.setUser_Phone(user_Phone);
				user.setUser_email(user_email);
				user.setUser_ManagerId(user_ManagerId);
				user.setUser_position(user_position);
								
				
				user.setUser_id(user_id);
			}	
	
		
	}
	public void requestReimbursement(User user) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("How much would you like to Reimburse: ");
		while(!sc.hasNextInt()) {
			System.out.println("Invalid input try again");
			sc.next();
		}
		
		int amount = ( sc.nextInt());
		System.out.println("Please send a picture of your receipt: ");
		while(!sc.hasNext()) {
			System.out.println("Invalid input try again");
			sc.next();
		}
		
		String picture =  sc.next()+" ";
		
		
		String sql = "INSERT INTO REQUESTS (EMPID, AMOUNT, PICTURE, PENDINGSTATE, MANAGER) VALUES ("+user.getUser_id()+","+amount+", '"+picture+"', 'Pending',"+user.getUser_ManagerId()+") ";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
			
		
		
	}
	
	
	public void ViewReimbursements(User user) throws SQLException {

			System.out.println("employeeId: "+user.getUser_id());

			String sql = "SELECT AMOUNT, PENDINGSTATE FROM REQUESTS WHERE EMPID = "+user.getUser_id()+"";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Request Amount\t\tRequest State");
			while(rs.next()) {
				
				int amount = rs.getInt("AMOUNT");
				String pendingState = rs.getString("PENDINGSTATE");
				System.out.println(amount+"\t\t\t"+pendingState);
			}	

		
	}

	public void ViewMyEmpReimbursements(User user) throws SQLException {

		System.out.println("employeeId: "+user.getUser_id());

		String sql = "SELECT AMOUNT, PENDINGSTATE FROM REQUESTS WHERE MANAGER = "+user.getUser_id()+"";
		Statement stmt= conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("Request Amount\t\tRequest State");
		while(rs.next()) {
			
			int amount = rs.getInt("AMOUNT");
			String pendingState = rs.getString("PENDINGSTATE");
			System.out.println(amount+"\t\t\t"+pendingState);
		}	

	
}
	public void viewAllPendingReimbursements(User user) throws SQLException {



			String sql = "SELECT * FROM REQUESTS WHERE PENDINGSTATE = 'Pending'";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Request ID:\tEmployee ID:\tRequest Amount:\t\tReceipt:\tRequest State:\tManager ID:");
			while(rs.next()) {
				
				int reqId = rs.getInt("REQID");
				int empId = rs.getInt("EMPID");
				int amount = rs.getInt("AMOUNT");
				String picture = rs.getString("PICTURE");
				String pendingState = rs.getString("PENDINGSTATE");
				int manager = rs.getInt("MANAGER");
				System.out.println(reqId+"\t\t"+empId+"\t\t"+amount+"\t\t\t"+picture+"\t\t"+pendingState+"\t\t"+manager+"\n");
			}	

		
	}
public void acceptDenyRequests(User user) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Would you like to accept or deny a request? \n\n(1)Accept\t(2)Deny");
		
		while(!sc.hasNextInt()) {
			System.out.println("Invalid input try again");
			sc.next();
		}
		
		int acceptDeny = ( sc.nextInt());
		System.out.println("Select a [Request ID] you would like to perform the previous action:");
		
		while(!sc.hasNextInt()) {
			System.out.println("Invalid input try again");
			sc.next();
		}
		
		int reqID = ( sc.nextInt());
			
		String sql;
		if(acceptDeny ==1) {
			sql = "UPDATE REQUESTS SET PENDINGSTATE = 'Accepted' WHERE REQID ="+reqID;
		}
		else if(acceptDeny ==2) {
			sql = "UPDATE REQUESTS SET PENDINGSTATE = 'Rejected' WHERE REQID ="+reqID;
		}
		else {
			System.out.println("You did not select one of the options");
			sql = "UPDATE REQUESTS SET PENDINGSTATE = 'Pending' WHERE REQID ="+reqID;
		}
		
		

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
			

		
	}

	
	public void viewEmployees(User user) throws SQLException {

			System.out.println("employeeId: "+user.getUser_id());

			String sql = "SELECT * FROM USERS";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
			
				String position = rs.getString("POSITION");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				int mymanager = rs.getInt("MYMANAGER");
				System.out.println("\nPosition: "+position+"__Firstname: "+firstname+"__Lastname: "+lastname+"__ManagerID: "+mymanager);
			}	

		
	}
	
}
