package com.group.j.functionality.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.group.j.functionality.StoreProduct;
import com.group.j.main.files.DatabaseConn;


public class StoreProductImpl implements StoreProduct {

	Scanner sc = new Scanner(System.in);
	
	
	void setProduct() {
		
		System.out.println("Enter Product Id>> ");
		int pId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Product Name>>");
		String pName = sc.nextLine();
		System.out.println("Enter Product Description>>");
		String pDesc = sc.nextLine();
		System.out.println("Enter Price>>");
		float pPrice = sc.nextFloat();
		System.out.println("Enter Quantity>>");
		int pQuantity = sc.nextInt();
	
		
		addProduct(pId, pDesc, pName, pPrice, pQuantity);
	}
	
	void addProduct(int pId, String pDesc, String pName, float pPrice,int pQuantity ) {
		
		try {
			
		Connection con = DatabaseConn.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into products(product_id, product_description, product_name, product_price, product_quantity) values(?,?,?,?,?)");
		
		ps.setInt(1,pId);
		ps.setString(2, pDesc);
		ps.setString(3, pName);
		ps.setFloat(4, pPrice);
		ps.setInt(5, pQuantity);
		
		int i = ps.executeUpdate();
		System.out.println("Product Details added successfully... " + i);
		
		con.close();
		ps.close();
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	
		StoreProductImpl sp = new StoreProductImpl();
		sp.setProduct();
	
	}
}
