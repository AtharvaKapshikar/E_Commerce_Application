

package com.group.j.funcationality.implemention;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.group.j.functionality.UserRegistration;

public class UserRegistrationImpl implements UserRegistration {
	
	private static final String DriverName = "oracle.jdbc.driver.OracleDriver";
	private static final String ConnURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String UserName = "system";
	private static final String Password = "system";
	//private static final String sql = "insert into ";
	

	Scanner sc= new Scanner(System.in);
	
	@Override
	public void setUserDetails() {
		
		System.out.println("Enter the first name>>");
		String fname = sc.next();
		System.out.println("Enter the last name>>");
		String lname = sc.next();
		System.out.println("Enter the username>> ");
		String username = sc.next();
		System.out.println("Enter the password>>");
		String password = sc.next();
		System.out.println("Enter the city>> ");
		String city = sc.next();
		System.out.println("Enter the mail id>> ");
		String email = sc.next();
		System.out.println("Enter the mobile number>> ");
		String mnumber = sc.next();
		
		try {
			saveIntoDatabase(fname,lname,username,password,city,email,mnumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void saveIntoDatabase(String fname,String lname,String username, String password, String city, String email, String mnumber) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
		Class.forName(DriverName);
		con= DriverManager.getConnection(ConnURL, UserName, Password);
		ps = con.prepareStatement("insert into userdetails (firstname,lastname,username,password,city,email,mobileno) values(?,?,?,?,?,?,?)");
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setString(3, username);
		ps.setString(4, password);
		ps.setString(5, city);
		ps.setString(6, email);
		ps.setString(7, mnumber);
		int i = ps.executeUpdate();
		System.out.println("Registration Successfully completed..." + i);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			ps.close();
		}
		
	}
	
}
