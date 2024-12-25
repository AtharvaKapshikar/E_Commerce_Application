package com.group.j.user.functionality.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.group.j.main.files.AppMain;
import com.group.j.main.files.DatabaseConn;
import com.group.j.user.functionality.implementation.ViewCart;

public class BuyProduct{

	Scanner sc = new Scanner(System.in);
	DatabaseConn dbc = new DatabaseConn();
	UserLogin ul = new UserLogin();
	ViewCart viewCart = new ViewCart();
	AppMain appMain = new AppMain();
	
	public void buyProductItem() throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			ul.checkCredentials();
			
			System.out.println("Enter the product id to buy product>> ");
			int productId = sc.nextInt();
			System.out.println("Enter the quantity>>");
			int productQuantity = sc.nextInt();
			
			con = dbc.getConnection();
			ps = con.prepareStatement("insert into cart(username,product_id,product_quantity,ispurchased) values(?,?,?,?)");
			
			ps.setString(1, ul.username);
			ps.setInt(2, productId);
			ps.setInt(3, productQuantity);
			ps.setInt(4, 0);
			
			int i = ps.executeUpdate();
			System.out.println("Product added into cart...");
			
			checkYesNo();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
			ps.close();
		}
	}
	
	void checkYesNo() throws SQLException {
		System.out.println("Do you want to buy more products? (Yes/No)");
		String ans = sc.next();
		String wantBuyMore = ans.toUpperCase();
		
		if(wantBuyMore.equals("YES")) {
			buyProductItem();
		}else if(wantBuyMore.equals("NO")){
			System.out.println("You want to view your cart? (Yes/No)");
			String wantView = sc.next();
			String wantViewCart = wantView.toUpperCase();
			if(wantViewCart.equals("YES")){
				viewCart.getCart();
			}else if(wantViewCart.equals("NO")) {
				appMain.getRun();
			}else {
				System.out.println("Invalid input enter Yes or No");
				checkYesNo();
			}
		}
	}
}
