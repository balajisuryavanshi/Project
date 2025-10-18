package com.basicCalculator;

import java.util.Scanner;

public class Calculator {
	public static double add(double a,double b) {
		return a + b;
	}
	public static double sub(double a,double b) {
		return a - b;
	}
	public static double Mul(double a,double b) {
		return a * b;
	}
	public static double Div(double a,double b) {
		if(b == 0) {
			System.out.println("Error :Division by zero");
			return 0;
		}
		return a / b;
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Number :");
		double Num1=sc.nextDouble();
		
		System.out.println("Enter Second Number :");
		double Num2=sc.nextDouble();
		
		System.out.println("1.Addition(+)");
		System.out.println("2.Substraction(-)");
		System.out.println("3.multiplication(*)");
		System.out.println("4.division(/)");
		
		System.out.println("Choose an Operation :");
		
		int choice = sc.nextInt();
		double Result=0;
		
		switch(choice) {
		case 1:
			Result = add(Num1 , Num2);
//			System.out.println("Addition of Two Number :"+Result);
			break;
			
		case 2:
			Result = sub(Num1 , Num2);
			break;
			
		case 3:
			Result = Mul(Num1 , Num2);
			break;
		
		case 4:
			Result = Div(Num1 , Num2);
			break;
		
	    default:
			System.out.println("Invalid choice");
		return;
		}
		System.out.println("Result = "+ Result);
		sc.close();
	}
	
}
