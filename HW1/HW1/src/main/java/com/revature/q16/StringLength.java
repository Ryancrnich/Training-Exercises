package com.revature.q16;

import java.util.Scanner;

public class StringLength {

	public static Scanner input = new Scanner(System.in);
	
	public static void howMany() {
	    System.out.println("Enter a string to determine its # of characters.");
	    String myString = input.nextLine();
	    System.out.println("\tTotal amount of characters in \"" + myString + "\": " + myString.length());
	}
}