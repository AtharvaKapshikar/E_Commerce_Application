package com.group.j.guest.functionality.implementation;

import java.util.Scanner;

import com.group.j.user.functionality.implementation.UserRegistrationImpl;

public class GuestNotPurchase {

	Scanner sc = new Scanner(System.in);
	
	public void guestNotPurchased () {
		
		System.out.println("If you want to purchase item please register..");
		System.out.println("If you want to register enter Yes else No >>");
		String ans = sc.nextLine();
		String wantRegister = ans.toUpperCase();
		
		if(wantRegister.equals("YES")) {
			UserRegistrationImpl userRegistrationImpl = new UserRegistrationImpl();
			userRegistrationImpl.setUserDetails();
		}else if(wantRegister.equals("NO")) {
			
		}else {
			System.out.println("Invalid input enter Yes or No");
			guestNotPurchased();
		}
	}
	
	public static void main(String[] args) {
		GuestNotPurchase gnp = new GuestNotPurchase();
		gnp.guestNotPurchased();
	}
}
