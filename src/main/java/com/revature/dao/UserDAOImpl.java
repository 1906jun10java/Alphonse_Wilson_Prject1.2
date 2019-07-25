package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bean.CustomerFunctions;
import com.revature.bean.Offer;
import com.revature.bean.Owned;
import com.revature.bean.User;
import com.revature.util.ConnFactory;


public class UserDAOImpl implements UserDAO {
	public static ConnFactory cf= ConnFactory.getInstance();
	public static Connection conn = cf.getConnection();

	public List<User> getUser() throws SQLException{
		
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM USERS";
		

				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User u = new User();
				String userName = rs.getString("username");
				u.setUser(userName);
				
				String userPass = rs.getString("pass");
				u.setPass(userPass);
				
				String userType = rs.getString("position");
				u.setUserType(userType);
				
				
			}

		return userList;
	}
public List<User> getUserid(User user) throws SQLException{
		
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM USERS";
		
		
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int userId = rs.getInt("EMPID");
				user.setUser_id(userId);
				
			}if(user.getUser_id() == user.getUser_id()) {
				System.out.println(user.getUser_id());
				
			}

		return userList;
	}
	
	
	public List<Owned> getOwnedList() throws SQLException {
	List<Owned> ownedList2 = new ArrayList<Owned>();

	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM OWNED");
	ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		String colName;
		
		Owned s = null;
			for (int i = 1; i <= columnsNumber; i++) {
				colName = rsmd.getColumnName(i);
				System.out.print(colName+" ["+rs.getString(i) + "] ");
			}
			System.out.println();
			ownedList2.add(s);
			return ownedList2;
		}

	public User getUserById(String id) throws SQLException {
		User u = null;
		String sql = "SELECT * FROM USERS WHERE username = ?";
		ResultSet rs = null;

				PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("EMPID");
				String userName = rs.getString("username");
				String userPass = rs.getString("pass");
				String userType = rs.getString("position");
				u = new User(userId,userName, userPass, userType);
			}

		return u;
	}

	@Override
	public User getUserById(String id, Connection conn) {
		User u = null;
		String sql = "SELECT * FROM USERS WHERE username = ?";
		ResultSet rs = null;
		try(PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("EMPID");
				String userName = rs.getString("username");
				String userPass = rs.getString("pass");
				String userType = rs.getString("position");
				u = new User(userId,userName, userPass, userType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!= null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return u;
	}

	@Override
	public int createUser(User user) throws SQLException {
		int usersCreated = 0;
		String sql = "INSERT INTO USERS(username, pass, position) VALUES (?,?,?)";

				PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getUserType());
			usersCreated = ps.executeUpdate();

		return usersCreated;
	}

	public static boolean loginConfirm(String userName, String userPass, String Position, User user) throws SQLException {
		CustomerFunctions customer = new CustomerFunctions();
		System.out.println("atempting login confirm");
		List<User> userList = new ArrayList<>();

			System.out.println("atempting try block");
			String sql = "SELECT * FROM USERS WHERE POSITION = '"+Position+"' AND USERNAME = '"+userName+"'";
			//String sql = "SELECT * FROM USERS ";
			System.out.println("select statement activated");
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User temp = new User();
				temp.setUserId(rs.getInt(1));
			//	customer.getProfile(user);
				System.out.println(temp.getUserId());
				temp.setUser(rs.getString(9));
			

				System.out.println(temp.getUser());

				temp.setPass(rs.getString(8));
			

				System.out.println(temp.getPass());

				userList.add(temp);
				int user_id = rs.getInt("EMPID");
				String user_position = rs.getString("POSITION");
				
				String user_FirstName = rs.getString("FIRSTNAME");
				String user_LastName = rs.getString("LASTNAME");
				String user_Phone = rs.getString("PHONE");
				
				String user_email = rs.getString("EMAIL");
				
				int user_ManagerId = rs.getInt("MYMANAGER");
				String user_name = rs.getString("username");
				String user_pass = rs.getString("PASS");
				System.out.println(user_id);
				
				System.out.println(user.getUser_id()+"#############");
//				user.setUser_id(user_id);
//				user.setUser_name(user_name);
//				user.setUser_pass(user_pass);
//				user.setUser_FirstName(user_FirstName);
//				user.setUser_LastName(user_LastName);
//				user.setUser_Phone(user_Phone);
//				user.setUser_email(user_email);
//				user.setUser_ManagerId(user_ManagerId);
//				user.setUser_position(user_position);
//				user.setUser_id(user_id);
				
			}
			
			

		for(User u : userList ) {
			if(u.getUser().equals(userName) && u.getPass().equals(userPass)) {
				return true;
			}
		}
		
		return false;
		
	}
	public void retreiveUserId(User user) throws SQLException {


			String sql = "SELECT EMPID, username FROM USERS";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String user_name = rs.getString("username");
				int user_id = rs.getInt("EMPID");
				if(user_name== "al") {
					user.setUserId(user_id);
				}
			}	


	}

	
	
		
}
		
		

	