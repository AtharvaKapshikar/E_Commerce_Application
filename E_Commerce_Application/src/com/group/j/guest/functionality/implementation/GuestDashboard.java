package com.group.j.guest.functionality.implementation;

import java.util.Scanner;

public class GuestDashboard {

	private int input;
	Scanner sc= new Scanner(System.in);
	
	public void getRun() {
		
		System.out.println("*******Welcome to E-Commerce based application******* ");
		System.out.println("Guest Operation ");
		System.out.println("1. View product item");
		System.out.println("2. Purchase item ");
		System.out.println("Enter your choice>>");
		try {
			 this.input = sc.nextInt();
			 
			 switch (input) {
			 case 1 : 
				 GuestViewProducs guestViewProducs = new GuestViewProducs();
				 guestViewProducs.getProductsItems();
				 break;
			 case 2 :
				GuestNotPurchase guestNotPurchase = new GuestNotPurchase();
				guestNotPurchase.guestNotPurchased();
				 break;
			default :
				System.out.println("Wrong input");
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
