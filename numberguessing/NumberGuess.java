package com.numberguessing;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Random rm = new Random();
		
		int number = rm.nextInt(100)+ 1;
		
		int maxAttempt = 7;
		int attempt = 0;
		boolean guessed = false;
		
		System.out.println("Welcome To The Guessing Game : ");
		System.out.println("Guess The Number Of 0 To 100.");
		System.out.println("You Have "+ maxAttempt +" attempts.\n");
		
		while(attempt < maxAttempt) {
			System.out.println("Guess The Number :");
			
			if(!sc.hasNextInt()) {
				System.out.println("Invalid Input !.Please enter a number.\n");
				sc.next();
				continue;
			}
			int userGuess = sc.nextInt();
			attempt++;
			
			if(userGuess == number) {
				System.out.println("Corrcet Guess. You Are Win " + attempt + " attempts.");
				guessed = true;
				break;
			} else if(userGuess < number) {
				System.out.println("Low Number!.Try Again");
			} else {
				System.out.println("High Number!.Try Again");
			}
			System.out.println("Attempts Left :" + (maxAttempt - attempt) +"\n");
		}
		if(!guessed) {
			System.out.println("Sorry!.You Are Failed!!");
			System.out.println("The Correct Number Was :" + number);
		}
		System.out.println("--Game Over--");
		sc.close();
		
	}
}
