package com.group.j.functionality.implementation;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.group.j.main.files.DatabaseConn;

public class PurchaseItem extends BuyProduct{

	static PurchaseItem pi = new PurchaseItem();
	ViewCart vc = new ViewCart();
	String isPurchased = null;
	Scanner sc = new Scanner(System.in);
	DatabaseConn dbc = new DatabaseConn();
	
	public void purchaseItem() {
		vc.getCart();
		String userName = vc.username;
		
		System.out.println("Do you want to purchase? (Yes/No) >>");//yes Yes YES
		isPurchased = sc.next();
		String ans = isPurchased.toUpperCase();
	
		if(ans.equals("YES")){
			try {
			Connection con = dbc.getConnection();
			Statement stmt = con.createStatement();
			System.out.println(vc.username);
			int i = stmt.executeUpdate("Delete from cart Where '" + vc.username + "'= cart.username");
			
			System.out.println("Deleted..." + i);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Successfully item purchased...");
		}else {
			vc.getCart();
		}
	}
	
	public static void main(String[] args) {
		pi.purchaseItem();
		
	}
}
