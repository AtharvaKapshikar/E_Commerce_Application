package com.group.j.admin.functionality.implementation;

import com.group.j.user.functionality.implementation.UserLogin;

public class DisplayAmount {
	
	static UserLogin ul = new UserLogin();
	CalculateBill cb = new CalculateBill();
	
	public void displayAmountToUser(String userName) {
	    float totalAmount = cb.calculateBill(userName);  
	    System.out.println("Final Amount to Pay for " + userName + ": " + totalAmount);
	}
	
	public static void main(String[] args) {
		DisplayAmount da = new DisplayAmount();
		da.displayAmountToUser(ul.username);
	}

}
