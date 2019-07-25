package com.revature.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bean.Offer;
import com.revature.dao.CarDAO;

import com.revature.dao.UserDAOImpl;
import com.revature.util.ConnFactory;



public class EmployeeFunctions {
	protected Car car = new Car();
	int yearManufactured;
	String carMake;
	String carModel;
	int carId = 0;
	UserDAOImpl userDao = new UserDAOImpl();

	int userId = 1;
	Scanner sc = new Scanner(System.in);
	public static ConnFactory cf= ConnFactory.getInstance();
	public static Connection conn = cf.getConnection();
	




	public void offerDecide(User user) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("would you like to reject(1) or accept(2) an offer");
		try {
			int decide = sc.nextInt();
			if(decide == 1) {
				System.out.println("Which Offer_id do you wish to reject");
				int reject = sc.nextInt();
				rejectOffer(reject);
			}
			else if (decide == 2) {
				System.out.println("Which Offer_id do you wish to accept");
				int accept = sc.nextInt();
				retreiveCarUserAmount(user, accept);
				acceptOffer(user.getOffer_id(), user.getCar_id(), user.getUser_id(), user.getOffer_price());
			//	makeUnavailable(user.getCar_id());
				rejectOffer(accept);
				
			}
			else {
				System.out.println("That was not one of the options");
			}
		}catch(Exception e) {
			
		}
		
		System.out.println("Accept/Decline");
	}

	public void viewPayments(User user) {
		System.out.println("View payments");
	}

	/*
	 * public void returnToMenu(User user) { System.out.println("Returned To Menu");
	 * }
	 */
	public void exitProgram(VariableCheck variable, User user) {
		user.setTravelTo("login");
		variable.setLoop(false);
		System.out.println("exiting.");
		// System.exit(0);
	}





	public void setOffer(int offer, User user, int carId) throws SQLException  {
		
		String sql = "INSERT INTO PENDINGOFFER (userId, carId, offerPrice) VALUES(?,?,?)";

				PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getUserId());
			ps.setInt(2, carId);
			ps.setInt(3, offer);
			ps.executeUpdate();

		

	}
	public void rejectOffer(int offer_id) throws SQLException  {
		//DELETE FROM PENDINGOFFER WHERE OFFER_ID = ?;


		String sql = "DELETE FROM PENDINGOFFER WHERE offerId = ?";
 
				PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, offer_id);
			
			ps.executeUpdate();

		
		
	}
	public void makeUnavailable(int car_id) throws SQLException  {
		//DELETE FROM PENDINGOFFER WHERE OFFER_ID = ?;
		//UPDATE LOT SET CAR_OWNER_STATE = 'Unavailable'WHERE CAR_ID = ?;
		String sql = "UPDATE LOT SET CAR_OWNER_STATE = 'Unavailable' WHERE CAR_ID = "+ car_id;
		                             
 
				PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.executeUpdate();
			


	}
	public void acceptOffer(int owned_id, int car_id, int user_id, int owned_amount_left) throws SQLException  {
		//DELETE FROM PENDINGOFFER WHERE OFFER_ID = ?;
		
		String sql = "INSERT INTO OWNED (CARID, USERID, owned_amount_left) VALUES(?, ?, ?)";


				PreparedStatement ps = conn.prepareStatement(sql);
			owned_id++;
			
			ps.setInt(1, car_id);
			ps.setInt(2, user_id);
			ps.setInt(3, owned_amount_left);
			//ps.setInt(4, owned_id);
			ps.executeUpdate();
			
			


	}
	public void retreiveCarUserAmount(User user, int offerId) throws SQLException {


			String sql = "SELECT * FROM PENDINGOFFER";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int offer_id = rs.getInt("offerId");
				int car_id = rs.getInt("carId");
				int user_id = rs.getInt("userId");
				int offer_price = rs.getInt("offerPrice");
				if(offer_id==offerId) {
					user.setCar_id(car_id);
					user.setUser_id(user_id);
					user.setOffer_price(offer_price);
					
				}
				
				
			}
			
			
		
	}


	



}
