package com.group.j.main.files;

import java.util.Scanner;

import com.group.j.functionality.implementation.UserLogin;
import com.group.j.functionality.implementation.UserRegistrationImpl;

public class AppMain {

	private int input;
	Scanner sc= new Scanner(System.in);
	
	void getrun() {
		
		System.out.println("*******Welcome to E-Commerce based application******* ");
		System.out.println("User Operation");
		System.out.println("1. User Registration  ");
		System.out.println("2. User Login ");
		System.out.println("3. User view Product item as Sorted Order");
		System.out.println("4. Buy Product ");
		System.out.println("5. View Cart ");
		System.out.println("6. Purchase the item");
		System.out.println("Admin Operation ");
		System.out.println("7. Add product item");
		System.out.println("9. Display amount to End User ");
		System.out.println("10.Check Quantity ");
		System.out.println("11. Check registered user ");
		System.out.println("12. Check the particular user history ");
		System.out.println("Guest Operation ");
		System.out.println("13. View product item");
		System.out.println("14. Not purchase item ");
		System.out.println("Enter your choice>>");
		try {
			 this.input = sc.nextInt();
			 
			 switch (input) {
			 case 1 : 
				 UserRegistrationImpl ur = new UserRegistrationImpl();
				 ur.setUserDetails();
				 break;
			 case 2 :
				 UserLogin userLogin = new UserLogin();
				 userLogin.checkCreadentials();
				 break;
			default :
				System.out.println("Wrong input");
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		AppMain am = new AppMain();
		am.getrun();
	}
}
