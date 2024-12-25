package com.group.j.admin.functionality.implementation;

import java.util.Scanner;

import com.group.j.user.functionality.implementation.UserLogin;

public class AdminDashboard {

	private int input;
	Scanner sc= new Scanner(System.in);
	UserLogin ul = new UserLogin();
	
	public void getRun() {
		
		System.out.println("*******Welcome to E-Commerce based application******* ");
		System.out.println("Admin Operation ");
		System.out.println("1. Add product item");
		System.out.println("2. Calculate Bill ");
		System.out.println("3. Display amount to End User ");
		System.out.println("4. Check Quantity ");
		System.out.println("5. Check registered user ");
		System.out.println("6. Check the particular user history ");
		System.out.println("Enter your choice>>");
		try {
			 this.input = sc.nextInt();
			 
			 switch (input) {
			 case 1 : 
				 StoreProductImpl storeProductImpl = new StoreProductImpl();
				 storeProductImpl.setProduct();
				 break;
			 case 2:
				 CalculateBill calculateBill = new CalculateBill();
				 calculateBill.calculateBill(ul.username);
			 case 3 :
				DisplayAmount displayAmount = new DisplayAmount();
				displayAmount.displayAmountToUser(ul.username);
				 break;
			 case 4:
				 QuantityCheck quantityCheck = new QuantityCheck();
				 quantityCheck.checkQuantity();
				 break;
			 case 5:
				 RegisteredUser registeredUser = new RegisteredUser();
				 registeredUser.checkRegisteredUser();
				 break;
			 case 6:
				 UserHistory userHistory = new UserHistory();
				 userHistory.viewPurchaseHistory();
				 break;
			default :
				System.out.println("Wrong input");
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
