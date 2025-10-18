package com.bankapplication;

import java.util.Scanner;

class bankAccount {
	private String accountHolderName;
	private double balance;
	
//	constructor
	public bankAccount(String accountHaolderName,double initialBalance) {
		this.accountHolderName = accountHolderName;
		if(initialBalance >= 0) {
			this.balance = initialBalance;
		} else {
			System.out.println("Balance is Insufficient.");
			this.balance = 0;
		}
	}
	public void deposit(double amount) {
		if(amount > 0 ) {
			balance += amount;
			System.out.print("Sucessfully Deposite."+ amount);
		}  else {
			System.out.println("Deposit Amount.");
		}
	}
	
	public void withdraw(double amount) {
		if(amount <= 0) {
			System.out.println("Withdraw Amount.");
		} else if(amount > balance) {
			System.out.println("Insufficient Balance."+ balance);
		} else {
			balance -= amount;
			System.out.println("sucessfully Withdraw Amount."+ amount);
		}
	}
	public void checkBalance() {
		System.out.println("current balance : "+ balance);
	}
}

public class SimpleBankingApp {

	public static void main(String[] args) 
	{
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Account Holder name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter Initial Balance : ");
		double initialBalance = sc.nextDouble();
		
		bankAccount account = new bankAccount(name,initialBalance);
		
		int choice;
		do {
			System.out.println("Banking Manu ");
			System.out.println("1.Deposit");
			System.out.println("2.WithDraw");
			System.out.println("3.initialBalance");
			System.out.println("4.exits");
			System.out.println("Enter Your Choice : ");
			choice = sc.nextInt();
			
		switch(choice) {
			case 1:
				System.out.print("Enter Deposite Amount : ");
				double depositAmount = sc.nextDouble();
				account.deposit(depositAmount);
				break;
			
			case 2:
				System.out.println("Enter Withdraw Amount : ");
				double withdrawAmount = sc.nextDouble();
				account.withdraw(withdrawAmount);
				break;
				
			case 3:
				account.checkBalance();
				break;
			
			case 4:
				System.out.println("Thank You For Using Banking System.");
				break;
				
			default :
				 System.out.println("Invalid Choice.");
		 	}
		} while(choice != 4);
		sc.close();
	}

}
