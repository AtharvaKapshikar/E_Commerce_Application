package com.group.j.functionality.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.group.j.main.files.AppMain;
import com.group.j.main.files.DatabaseConn;

public class ViewProducts{

	Scanner sc = new Scanner(System.in);
	DatabaseConn dbc = new DatabaseConn();
	AppMain appMain = new AppMain();
	BuyProduct buyProduct = new BuyProduct();
	
	public void getProductsItems() throws SQLException {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		
		con = dbc.getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from products");
		
		while(rs.next()) {
			System.out.println("Product Id>> " + rs.getInt(1));
			System.out.println("Product Name>> " + rs.getString(3));
			System.out.println("Product Description>> " + rs.getString(2));
			System.out.println("Available Quantity>> " + rs.getInt(5));
			System.out.println("Price>> " + rs.getFloat(4));
		}
		checkYesNo();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
			stmt.close();
			rs.close();
		}
	}
	
	void checkYesNo() throws SQLException {
		
		System.out.println("Do you want to buy product? (Yes/No) >> ");
		String ans = sc.nextLine();
		String wantBuyProduct = ans.toUpperCase();
		
		if(wantBuyProduct.equals("YES")) {
			buyProduct.buyProductItem();
		}else if(wantBuyProduct.equals("NO")) {
			appMain.getRun();
		}else {
			System.out.println("Invalid input enter Yes or No");
			checkYesNo();
		}
	}
}
