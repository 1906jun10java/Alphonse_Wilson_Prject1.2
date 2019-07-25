package com.revature.menu;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bean.CustomerFunctions;
import com.revature.bean.EmployeeFunctions;
import com.revature.bean.User;
import com.revature.bean.VariableCheck;

import com.revature.bean.*;

public class EmployeeMenu extends EmployeeFunctions{
	public User LoginEmployee(User user) {
		VariableCheck variables = new VariableCheck();
		CustomerFunctions customer = new CustomerFunctions();
		Scanner sc = new Scanner(System.in);
		variables.setLoop(true);
		variables.setLogin(false);
		EmployeeFunctions ef = new EmployeeFunctions();

		while (variables.getLoop() == true) {
//			try {
//				//customer.getProfile(user);
//			} catch (SQLException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}

			if (variables.getLogin() == false) {
				System.out.println("1. View Profile\n2. Update Profile \n3. Make reimbursement request "
						+ "\n4. View reimbursement request(s)\n5. View my employee reimbursement request(s) \n6 Accept/Deny View reimbursement request(s) \n7. Signin new employee/manager\n8. view all employees and there managers \n9. Exit");
				while (!sc.hasNextInt()) {
					System.out.println("1. Add Car \n2. Remove Car \n3. Accept/Decline Offer \n4.Exit");
					sc.next();
				}

				variables.setMenuOption(sc.nextInt());
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
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					/*
					 * add another menu to show offers and to accept or decline them. 
					 */
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
					try {
						customer.ViewMyEmpReimbursements(user);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 6:
					try {
						customer.viewAllPendingReimbursements(user);
						customer.acceptDenyRequests(user);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 7:
					SignupMenu newSignin = new SignupMenu();
					newSignin.signinNewUser(user);
		        	
		            break;
				case 8:
					try {
						customer.viewEmployees(user);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            break;	
				case 9:
					ef.exitProgram(variables, user);
					break;
					
				/*
				case 5:
					System.out.print("Enter");
					if ((variables.getEmployee() == true || variables.getCustomer() == true)
							&& variables.getUser() != null && variables.getPass() != null) {
						// check the table of either employee or customer
						// and compare the username and password
						// then set loops to false
						variables.setLoop(false);
					}
					// call or maker function here to compare the
					// usernames and password in the employee/customer table	
					break;
				*/
				
				default:
					user.setCustomer(false);
					user.setEmployee(true);
					user.setUser(null);
					user.setUser(null);
					variables.setLogin(false);

					System.out.println("Something went wrong. Please enter your selected options correctly.");
					System.out.println("====================================================================");
				}
				}
			}
		return user;
	}



}
