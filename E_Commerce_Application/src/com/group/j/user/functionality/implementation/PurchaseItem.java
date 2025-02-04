package com.group.j.user.functionality.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.group.j.main.files.DatabaseConn;

public class PurchaseItem {

    String isPurchased = null;
    Scanner sc = new Scanner(System.in);
    DatabaseConn dbc = new DatabaseConn();
    ViewCart vc = new ViewCart();
    int count = 0;

    public void purchaseItem() {
        
        vc.getCart();
        String userName = vc.username;
        
        System.out.println("Do you want to purchase? (Yes/No) >>");
        isPurchased = sc.next();
        String ans = isPurchased.toUpperCase();
        
        if(ans.equals("YES")) {
            try (Connection con = dbc.getConnection(); Statement stmt = con.createStatement()) {
                System.out.println(userName);
                
                // Query to get products in cart
                String query = "SELECT p.product_name, p.product_price, c.product_id, c.product_quantity " +
                        "FROM cart c " +
                        "JOIN products p ON c.product_id = p.product_id " +
                        "WHERE c.username = ?"; 

                // Prepare statement and execute query
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setString(1, userName);
                    ResultSet rs = pstmt.executeQuery();
                    
                    boolean found = false;  // Flag to check if products were found in cart
                    
                    while (rs.next()) {
                        found = true;

                        // Retrieve product and quantity from the result set
                        int pId = rs.getInt("product_id");
                      //  String pName = rs.getString("product_name");
                       // float productPrice = rs.getFloat("product_price");
                        int pQuantity = rs.getInt("product_quantity");

//                        // Print product details
//                        System.out.println("Username >> " + userName);
//                        System.out.println("Product id >> " + pId);
//                        System.out.println("Product Name >> " + pName);
//                        System.out.println("Quantity >> " + pQuantity);
                        
                        // Update product quantity in products table
                        String updateQuery = "UPDATE products SET product_quantity = product_quantity - ? WHERE product_id = ?";
                        try (PreparedStatement updatePstmt = con.prepareStatement(updateQuery)) {
                            updatePstmt.setInt(1, pQuantity);
                            updatePstmt.setInt(2, pId);
                            updatePstmt.executeUpdate();
                            
                            
                        }
                        
                       // updatePstmt.close();
                        
                        String updateQuery1 = "UPDATE cart SET isPurchased = ? WHERE username = ? AND product_id = ?";
                        try (PreparedStatement updatePstmt1 = con.prepareStatement(updateQuery1)) {
//                            deletePstmt.setString(1, userName);
//                            int deletedCount = deletePstmt.executeUpdate();
                        	updatePstmt1.setInt(1, 1);  // Set isPurchased to true
                        	updatePstmt1.setString(2, userName);
                        	updatePstmt1.setInt(3, pId);
                        	updatePstmt1.executeUpdate();
                        
                        	updatePstmt1.close();
                        	
                        }
                       
                    }
                   
                    
                   // int pId = rs.getInt("product_id");
                    
                    // Delete the cart items
                 //   String deleteQuery = "DELETE FROM cart WHERE username = ?";
                    
                    rs.close();
                   
                }
               
                System.out.println("Successfully item purchased...");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            vc.getCart();
        }
    }
}
