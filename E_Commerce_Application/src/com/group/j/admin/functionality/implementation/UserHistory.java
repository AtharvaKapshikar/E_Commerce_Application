package com.group.j.admin.functionality.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.group.j.main.files.DatabaseConn;

public class UserHistory {

	DatabaseConn dbc = new DatabaseConn();
	Scanner sc = new Scanner(System.in);
	
	public void viewPurchaseHistory() throws SQLException {
        System.out.println("Enter the username to view purchase history: ");
        String username = sc.next(); // Admin enters username to see purchase history

        Connection con = dbc.getConnection();
        Statement stmt = con.createStatement();        
        
        String query = "SELECT * from cart ";

        ResultSet rs = stmt.executeQuery(query); 
        
        while(rs.next()){      
        	if(rs.getInt("ispurchased") == 1) {
        		int pId = rs.getInt("product_id");
        		//String pName = rs.getString("product_name");
        		int pQuantity = rs.getInt("product_quantity");

        		Statement productStmt = con.createStatement();
        		ResultSet productRS = stmt.executeQuery("select product_name from products where product_id ='" + pId + "'");
        		while(productRS.next()) {
        		String pName = productRS.getString("product_name");
        		// Print product details
        		System.out.println("Username >> " + username);
        		System.out.println("Product id >> " + pId);
        		System.out.println("Product Name >> " + pName);
        		System.out.println("Quantity >> " + pQuantity);
        		}
        		productRS.close();
        		productStmt.close();
        	
        	}
        }
        rs.close();
        stmt.close();
        con.close();
        
    }
	
	public static void main(String[] args) throws SQLException {
		UserHistory uh = new UserHistory();
		uh.viewPurchaseHistory();
	}
}
