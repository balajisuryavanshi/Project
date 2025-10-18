package com.factorialcalculrecurion;

import java.util.Scanner;

public class FactorialCalRecursion {
	public static long fact(int n) {
		if(n < 0) {
		throw new IllegalArgumentException("Factorial is not defined negative number :");
		}
		if(n == 0 || n == 1) {
			return 1;
		}
		return n * fact(n - 1);
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number :");
		int num = sc.nextInt();
		
		try {
			long result = fact(num);
			System.out.println("Factorial of " + num + " is : " +result);
			
		} catch(IllegalArgumentException ie) {
			ie.printStackTrace();
		}
		System.out.println("End Program.");
		sc.close();
	}

}
