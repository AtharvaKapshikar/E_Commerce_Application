package com.group.j.functionality.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.group.j.main.files.AppMain;
import com.group.j.main.files.DatabaseConn;
import com.sun.xml.internal.ws.api.message.Attachment;

public class UserLogin {
	
	private static final String sql = "select * from userdetails";

	Scanner sc = new Scanner(System.in);
	static String username = null;
	String password = null;
	int checkAttemp = 0;
	AppMain appMain = new AppMain();
	
	public void checkCredentials() {
		
		System.out.println("Enter the username>> ");
		username = sc.next();
		System.out.println("Enter the password>>");
		password = sc.next();
		
		boolean checkLogin = false;
		
		try {
			Connection con = DatabaseConn.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			String usern = rs.getString(3);
			String pass = rs.getString(4);
			
			if(username.equals(usern) && password.equals(pass)) {
				checkLogin = true;
				break;
				//System.out.println("Successfully login...");
			}
		}
			
		if(checkLogin == true) {
			System.out.println("Successfully login...");
		}else {
			System.out.println("Invalid creadentials");
			
			checkAttemp++;
			if(checkAttemp>5) {
				System.out.println("Login attempt limit exceed...! login after 5 min");
				appMain.getRun();
				return;
			}else {
				checkCredentials();
			}
		}	
		con.close();
		stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
