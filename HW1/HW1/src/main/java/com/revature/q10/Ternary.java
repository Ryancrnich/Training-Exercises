package com.revature.q10;

import java.util.Scanner;

public class Ternary{
	
	public static Scanner input = new Scanner(System.in);
	public static int a;
	public static int b;
	public static int answer;

	public static void minFind() {		
		System.out.println("Find The Minimum: ");
		System.out.println("Enter first number: ");
		a = input.nextInt();
		System.out.println("Enter second number: ");
		b = input.nextInt();		
		answer = a < b ? a : b;
		System.out.println("The smallest number is: " + answer);
	}
}