package com.group.j.user.functionality.implementation;

import java.util.Scanner;

public class UserDashboard {
	
	private int input;
	Scanner sc= new Scanner(System.in);
	
	public void getRun() {
		
		System.out.println("*******Welcome to E-Commerce based application******* ");
		System.out.println("User Operation");
		System.out.println("1. User Registration  ");
		System.out.println("2. User Login ");
		System.out.println("3. View Products");
		System.out.println("4. Buy Product ");
		System.out.println("5. View Cart ");
		System.out.println("6. Purchase the item");
		System.out.println("Enter your choice>>");
		try {
			 this.input = sc.nextInt();
			 
			 switch (input) {
			 case 1 : 
				 UserRegistrationImpl userRegistrationImpl = new UserRegistrationImpl();
				 userRegistrationImpl.setUserDetails();
				 break;
			 case 2 :
				 UserLogin userLogin = new UserLogin();
				 userLogin.checkCredentials();
				 break;
			 case 3:
				 ViewProducts viewProducts = new ViewProducts();
				 viewProducts.getProductsItems();
				 break;
			 case 4:
				 BuyProduct buyProduct = new BuyProduct();
				 buyProduct.buyProductItem();
				 break;
			 case 5:
				 ViewCart viewCart = new ViewCart();
				 viewCart.getCart();
				 break;
			 case 6:
				 PurchaseItem purchaseItem = new PurchaseItem();
				 purchaseItem.purchaseItem();
				 break;
			default :
				System.out.println("Wrong input");
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
