package com.revature.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.util.ConnFactory;

public class LoginFunctions {
	public static ConnFactory cf= ConnFactory.getInstance();
	public static Connection conn = cf.getConnection();
	public boolean checkLoginEmployee(User user) throws SQLException{

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(//"INSERT INTO PENDINGOFFER(OFFER_ID)(26, 'Alphonse music');"// have to insert OFFER_ID  ,  USER_ID   ,   CAR_ID,   OFFER_PRICE   ,    and  OFFER_PRICE 
				 "SELECT * FROM USERS");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		String colName;
		int yes = 0;
	
		while (rs.next()) {
			
			if(user.getUser().equals(rs.getString(2)) && user.getPass().equals(rs.getString(3))) {
				yes = 1;
				user.setUserId(rs.getInt(1));
			}
		
		}
		if(yes == 1) {
			return true;
		}
		else {
			return false;

		}
		
	
		
	}
	public boolean checkLoginCustomer() {
		return false;
		
	}
	
	
	
	
}
