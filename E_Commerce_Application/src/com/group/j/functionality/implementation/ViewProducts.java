package com.group.j.functionality.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.group.j.main.files.DatabaseConn;

public class ViewProducts {

	Scanner sc = new Scanner(System.in);
	DatabaseConn dbc = new DatabaseConn();
	
	public void getProductsItems() {
		try {
			
		
		Connection con = dbc.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from products");
		
		while(rs.next()) {
			System.out.println("Product Id>> " + rs.getInt(1));
			System.out.println("Product Name>> " + rs.getString(3));
			System.out.println("Product Description>> " + rs.getString(2));
			System.out.println("Available Quantity>> " + rs.getInt(5));
			System.out.println("Price>> " + rs.getFloat(4));
		}
		con.close();
		stmt.close();
		rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
