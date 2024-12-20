package com.group.j.funcationality.implemention;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin {
	
	private static final String DriverName = "oracle.jdbc.driver.OracleDriver";
	private static final String ConnURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String UserName = "system";
	private static final String Password = "system";
	private static final String sql = "select * from userdetails";

	Scanner sc = new Scanner(System.in);
	void checkCreadentials() {
		
		System.out.println("Enter the username>> ");
		String username = sc.next();
		System.out.println("Enter the password>>");
		String password = sc.next();
		
		try {
			Class.forName(DriverName);
			Connection con = DriverManager.getConnection(ConnURL, UserName, Password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			String usern = rs.getString(3);
			String pass = rs.getString(4);
			if(username.equals(usern) && password.equals(pass)) {
				System.out.println("Successfully login...");
			}else {
				System.out.println("Invalid username and password");
			}
		}
		con.close();
		stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
