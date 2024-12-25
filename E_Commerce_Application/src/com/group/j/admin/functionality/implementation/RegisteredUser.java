package com.group.j.admin.functionality.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.group.j.main.files.DatabaseConn;

public class RegisteredUser {

	DatabaseConn dbc = new DatabaseConn();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void checkRegisteredUser() throws SQLException {
		
		con = dbc.getConnection();
		String sql = "select * from userdetails";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Username >> " + rs.getString("username"));
				System.out.println("First Name >> " + rs.getString("firstname"));
				System.out.println("Last Name >> " + rs.getString("lastname"));
				System.out.println("Email id >> " + rs.getString("email"));
				System.out.println("Mobile >> " + rs.getString("mobileno"));
				System.out.println("City >> " + rs.getString("city"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
			ps.close();
			rs.close();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		RegisteredUser ru = new RegisteredUser();
		ru.checkRegisteredUser();
	}
}
