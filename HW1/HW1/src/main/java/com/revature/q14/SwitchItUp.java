package com.revature.q14;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SwitchItUp {

	public static Scanner input = new Scanner(System.in);
	public static int x;
	public static String myString;
	
	public static void switchTime() {
		
		System.out.println("Please enter your choice (only the integer i.e. 1):\n\t1. Find the Square Root of a Number\n\t2. Display Today's Date\n\t3. Split \"I am learning Core Java\" into an array");
		x = input.nextInt();
		switch(x) {
			case 1: 
				System.out.println("\tEnter an Integer to get its Square Root: ");
				x = input.nextInt();
				System.out.println("\tThe Square Root of " + x + " is " + Math.sqrt(x));
				break;
			case 2:
				DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDateTime now = LocalDateTime.now();
				System.out.println("\t" + date.format(now));
				break;
			case 3:
				myString = "I am learning Core Java";
				System.out.println("\t" + myString);
				String myArray[] = myString.split(" ");
				for (int i = 0; i < myArray.length; i++){
				      System.out.println("\t" + myArray[i]);
				}
				break;	
			default:
				switchTime();
			break; 
		}
	
	}
}
