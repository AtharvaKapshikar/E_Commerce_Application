package com.group.j.functionality.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.group.j.main.files.AppMain;
import com.group.j.main.files.DatabaseConn;

public class ViewCart{

    DatabaseConn dbc = new DatabaseConn();
    UserLogin ul = new UserLogin();
    Scanner sc = new Scanner(System.in);

    AppMain appMain = new AppMain();
    String username = null;

   public void getCart() {
        try {
            ul.checkCredentials(); 
            username =  ul.username;

            Connection con = dbc.getConnection();
            Statement stmt = con.createStatement();        
            
            String query = "SELECT p.product_name, p.product_price, c.product_id, c.product_quantity " +
                           "FROM cart c " +
                           "JOIN products p ON c.product_id = p.product_id " +
                           "WHERE c.username = '" + ul.username + "'"; 

            ResultSet rs = stmt.executeQuery(query); 

            boolean found = false;  // Flag to check if products were found in cart
            float totalPrice = 0;  // Ensure totalPrice starts from 0 each time
            float allProductPrice = 0;

            while (rs.next()) {
                found = true;

                // Retrieve product and quantity from the result set
                int pId = rs.getInt("product_id");
                String pName = rs.getString("product_name");
                float productPrice = rs.getFloat("product_price");
                int pQuantity = rs.getInt("product_quantity");

                // Print product details
                System.out.println("Username >> " + ul.username);
                System.out.println("Product id >> " + pId);
                System.out.println("Product Name >> " + pName);
                System.out.println("Quantity >> " + pQuantity);

                totalPrice += productPrice * pQuantity;  // Update total price
                System.out.println("Product Price >> " + totalPrice);
                
                allProductPrice += totalPrice;
            }
            
            System.out.println("All product price>>" +allProductPrice);

            if (!found) {
                System.out.println("No products added to cart.");
            }

            con.close();
            stmt.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
   void checkYesNO() {
	   
	   System.out.println("Do you want to purchase the products? (Yes/No)");
		String ans = sc.next();
		String wantPurchase = ans.toUpperCase();
		
		if(wantPurchase.equals("YES")) {
		    PurchaseItem purchaseItem = new PurchaseItem();
			purchaseItem.purchaseItem();
		}else if(wantPurchase.equals("NO")){
				appMain.getRun();
			}else {
				System.out.println("Invalid input enter Yes or No");
				checkYesNO();
			}
		}
   }
