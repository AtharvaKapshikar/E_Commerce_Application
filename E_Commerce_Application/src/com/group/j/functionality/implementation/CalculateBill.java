package com.group.j.functionality.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group.j.main.files.DatabaseConn;

public class CalculateBill {

	DatabaseConn dbc = new DatabaseConn();
	static UserLogin ul = new UserLogin();
	
    
	
	public float calculateBill(String userName) {
	    float totalBill = 0.0f;
	    try {
	        Connection con = dbc.getConnection();
	        String query = "SELECT p.product_price, c.product_quantity FROM cart c JOIN products p ON c.product_id = p.product_id WHERE c.username = ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setString(1, userName);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            float productPrice = rs.getFloat("product_price");
	            int quantity = rs.getInt("product_quantity");
	            totalBill += productPrice * quantity;
	        }

	        // Add taxes or other additional charges if needed
	        float tax = totalBill * 0.10f;  // Example: 10% tax
	        totalBill += tax;

	        // You can also consider discounts, shipping, etc. here.
	        System.out.println("Total Bill for " + userName + ": " + totalBill);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return totalBill;
	}
	
	public static void main(String[] args) {
	String userName = ul.username;
		CalculateBill cb = new CalculateBill();
		cb.calculateBill(userName);
	}

}
