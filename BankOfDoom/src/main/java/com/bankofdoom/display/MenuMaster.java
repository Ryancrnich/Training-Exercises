package com.bankofdoom.display;
import java.util.Scanner;
import com.bankofdoom.display.MenuMethod;
import com.bankofdoom.driver.*;
public class MenuMaster {		
	private static String s;
	
	private static String tryAgain = "Please enter Y if you have an existing"
			+ " account and wish to login\n"
			+ "Please enter N if you would like to create a new account";
	private static String thankYouMsg= "Thank you for choosing Bank of Doom for"
			+ " all your Supervillan Banking needs!";

	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		IOBank io = new IOBank();

		System.out.println("Welcome to Bank of Doom!");

		System.out.println("Owned by LuthorCorp \n"
				+tryAgain);


		s = sc.next();
		
		s = s.toLowerCase();
		
		switch(s) {

		case "x":
			System.out.println(thankYouMsg);
			break;
		case"y":
			if(IOBank.userLogin()) MenuMethod.displayMainMenu();;
			break;
		case "n":
			io.userPersonalInfo();
			io.writeUserFile();
			break;
		default:
			System.out.println("Invalid Option! Self-destruct sequence "
					+ "initiated!\n"+thankYouMsg);

	}
		System.out.println("Thank you for playing! Shutting down!");
	sc.close();
}
	
}
