package com.group.j.admin.functionality.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.group.j.main.files.AppMain;
import com.group.j.main.files.DatabaseConn;

public class QuantityCheck {

	DatabaseConn dbc = new DatabaseConn();
	Scanner sc = new Scanner(System.in);
	AppMain appMain = new AppMain();
	
	public void checkQuantity() throws SQLException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			System.out.println("Enter product id to check quantity>>");
			int inputPID = sc.nextInt();
			
			con = dbc.getConnection();
			stmt = con.createStatement();
			String sql = "select product_quantity from products where product_id = '" + inputPID +"'" ;
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int pQuantity = rs.getInt("product_quantity");
				System.out.println("Product quantity>>" + pQuantity);
			}
			
			System.out.println("Do you want to check other products quantity? (Yes/No)");
			String ans = sc.nextLine();
			String wantMoreCheck = ans.toUpperCase();
			
			if(wantMoreCheck.equals("Yes")) {
				checkQuantity();
			}else if(wantMoreCheck.equals("NO")) {
				appMain.getRun();
			}else {
				System.out.println("Invalid input enter Yes or No");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
			stmt.close();
			rs.close();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		QuantityCheck qc = new QuantityCheck();
		
		qc.checkQuantity();
	}
}
