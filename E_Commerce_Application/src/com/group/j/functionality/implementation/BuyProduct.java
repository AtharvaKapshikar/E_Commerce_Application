package com.group.j.functionality.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Scanner;

import com.group.j.main.files.DatabaseConn;

public class BuyProduct {

	Scanner sc = new Scanner(System.in);
	DatabaseConn dbc = new DatabaseConn();
	UserLogin ul = new UserLogin();
	
	
	public void buyProductItem(){
		
		try {
			
			ul.checkCreadentials();
			
			System.out.println("Enter the product id to buy product>> ");
			int productId = sc.nextInt();
			System.out.println("Enter the quantity>>");
			int productQuantity = sc.nextInt();
			
			Connection con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into cart(username,product_id,product_quantity) values(?,?,?)");
			ps.setString(1, ul.username);
			ps.setInt(2, productId);
			ps.setInt(3, productQuantity);
			
			int i = ps.executeUpdate();
			
//			Statement stmt = con.createStatement();
//			stmt.executeUpdate("SELECT products.product_name,products.product_price,cart.product_name,cart.product_price FROM \r\n" + 
//					"products INNER JOIN cart ON products.product_id=cart.product_id ");
			
			con.close();
			ps.close();
			//stmt.close();
			//System.out.println(cart);
			System.out.println("Do you want to buy more products? (Yes/No)");
			String ans = sc.next();
			
			String wntBuyMore = ans.toUpperCase();
			
			if(wntBuyMore.equals("YES")) {
				buyProductItem();
				
			}else {
				
				System.out.println("You want to view your cart? (Yes/No)");
				String wantView = sc.next();
				String wantViewCart = wantView.toUpperCase();
				
//				if(wantViewCart.equals("YES")) {
//					cart.forEach((k,v) -> System.out.println("Proudt Id>> " + k + " Product quantity>> " + v));
//				}else {
//					System.out.println("Thank you");
//				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		BuyProduct bp = new BuyProduct();
		bp.buyProductItem();
	}
}
