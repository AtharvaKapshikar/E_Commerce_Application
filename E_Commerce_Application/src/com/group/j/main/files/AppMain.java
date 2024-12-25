package com.group.j.main.files;

import java.util.Scanner;

import com.group.j.admin.functionality.implementation.AdminDashboard;
import com.group.j.guest.functionality.implementation.GuestDashboard;
import com.group.j.user.functionality.implementation.UserDashboard;

public class AppMain {

	private int input;
	Scanner sc= new Scanner(System.in);
	
	public void getRun() {
		
		System.out.println("*******Welcome to E-Commerce based application******* ");
		System.out.println("1. User");
		System.out.println("2. Admin");
		System.out.println("3. Guest");
		System.out.println("Enter your choice>>");
		
		try {
			 this.input = sc.nextInt();
			 
			 switch (input) {
			 case 1 : 
				 UserDashboard userDashboard = new UserDashboard();
				 userDashboard.getRun();
				 break;
			 case 2 :
				AdminDashboard adminDashboard = new AdminDashboard();
				adminDashboard.getRun();
				 break;
			 case 3:
				 GuestDashboard guestDashboard = new GuestDashboard();
				 guestDashboard.getRun();
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
		am.getRun();
	}
}
