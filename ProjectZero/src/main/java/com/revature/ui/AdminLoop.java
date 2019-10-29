package com.revature.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Person;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.PersonDaoImpl;

public class AdminLoop {
public static void adminLoop(Scanner in) {
	String un = "";
	AccountDaoImpl adi = new AccountDaoImpl();
	PersonDaoImpl pdi = new PersonDaoImpl();

	Person opAdmin = new Person();
	boolean identity = false;
	while (identity == false) {System.out.println("Enter User Name:");
	un = in.nextLine();
	System.out.println("Enter Password:");
	String pw = in.nextLine();
	if(pdi.checkUser(un, pw)== true	)
	//	& opCust instanceof Customer
		{			
		try {
			opAdmin =  pdi.getPersonByUN(un);
			//opCust.setUserId(userId);
			 System.out.println("Welcome "+opAdmin.getFirstName());
			 //System.out.println(opCust.getUserId());
				identity = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} else {
		System.out.println("User Name/Pass word combination is invalid.");
	}
}
	try {
		System.out.println(pdi.getAllPersons());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int putIn=0;
	boolean loggedIn = true;
	while (loggedIn == true) {
	while(putIn!= 5) {
	System.out.println("Press 1 to create a User login");

	//System.out.println("Press  to update Users");
	System.out.println("Press 2 to delete Users");
	System.out.println("Press 3 to log out");

	putIn = in.nextInt();

	
	switch(putIn) {
		case 1:
			boolean nameFree = false;
			while(nameFree ==false) {
			
			System.out.println("Enter First Name");
			String fn = in.nextLine();
			System.out.println("Enter Last Name");
			String ln = in.nextLine();
			System.out.println("Enter a potential User Name");
			String us = in.nextLine();
		if(pdi.checkAvailability(us)==true) {

			System.out.println("User Name Available \n Enter a Password");
			String pw = in.nextLine();
			Person newClient = new Person(fn,ln,un,pw);
			try {
				pdi.insertPerson(newClient);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("new user added");
			nameFree = true;
			} else {System.out.println("Username/ password combination is invalid");}}
	
		case 2:
			int input = 0;
			boolean deleting = false;
			while(deleting ==false) {
				System.out.println("Press 1 to delete a specific User");
				System.out.println("Press 2 to delete all Users");
				input = in.nextInt();
				switch(input) {
				case 1:
					System.out.println("Input the User ID of the person you would like to remove");
					int unlucky = in.nextInt();
					pdi.removeAcct(unlucky);
					System.out.println("User removed from database");
					break;
				case 2:
					System.out.println("Are you sure you want to delete all personnel records? \n y/n");
					String s = in.nextLine();
					if (s.equals("y")) {
						pdi.removeAllAcct();
						System.out.println("All users removed from database");
					}
					else {break;}
					break;
				}
			}
			break;
		case 3:
			System.out.println("Logging out, returning to mainscreen");
			loggedIn = false;
			return;
	
}
	}
	}
}
}
