package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AdminMenuDao;
import com.revature.util.JDBConnector;

public class AdminMenuDaoImpl implements AdminMenuDao {
	
	static LoginDaoImpl ldi = new LoginDaoImpl();

	static Scanner input = new Scanner(System.in);
	public static JDBConnector jdbc = JDBConnector.getInstance();
	
	public String currentUser;
	public int currentAccount;
	public int howManyAccounts;
	
	public void adminMenu(String currentUser, int currentAccount) throws SQLException {
		this.currentUser = currentUser;
		this.currentAccount = currentAccount;
		System.out.println("Welcome " + currentUser + "!");
		System.out.println("What would you like to do?");
		System.out.println(" 1. Check Balances\n 2. Withdraw\n 3. Deposit\n 4. Open a New Account\n 5. View Customer Information");
		System.out.println("(Please enter numerical answers only i.e. 1 or 2)");
		String answer = input.nextLine();
		
		//1 WILL SEND TO checkBalance() METHOD
		if (answer.equals("1")) {
			checkBalances(currentAccount);
			System.out.println();
			System.out.println("////////////////////\n");
			adminMenu(currentUser, currentAccount);
		}
		
		//2 Withdraw
		else if (answer.equals("2")) {
			checkBalances(currentAccount);
			double strToDouble = 0;
			System.out.println("Are you trying to withdraw from a checking or savings account? (0 for Checking, 1 for Savings)");
			int choice = input.nextInt();
			System.out.println("Which account of that type are you trying to withdraw from?");
			System.out.println("(Enter the integer only ie for #1, type 1)");
			int choice1 = input.nextInt();
			int temp = 0;
			while (temp == 0) {
				System.out.println("How much would you like to withdraw?");
				double dAmount = input.nextDouble();
				if (dAmount < 0) {
					System.out.println("You cannot withdraw a negative amount.");
					continue;
				}
				else {
					DecimalFormat numberFormat = new DecimalFormat("#.00");
					String round = numberFormat.format(dAmount);
					strToDouble = Double.parseDouble(round);
					temp = 1;
				}
			}
			withdraw(choice, choice1, strToDouble);
		}
		
		//3 Deposit
		else if (answer.equals("3")) {
			checkBalances(currentAccount);
			double strToDouble = 0;
			System.out.println("Are you trying to deposit to a checking or savings account? (0 for Checking, 1 for Savings)");
			int choice = input.nextInt();
			System.out.println("Which account of that type are you trying to deposit to?");
			System.out.println("(Enter the integer only ie for #1, type 1)");
			int choice1 = input.nextInt();
			int temp = 0;
			while (temp == 0) {
				System.out.println("How much would you like to deposit?");
				double dAmount = input.nextDouble();
				if (dAmount < 0) {
					System.out.println("You cannot deposit a negative amount.");
					continue;
				}
				else {
					DecimalFormat numberFormat = new DecimalFormat("#.00");
					String round = numberFormat.format(dAmount);
					strToDouble = Double.parseDouble(round);
					temp = 1;
				}
			}
			System.out.println(strToDouble);
			deposit(choice, choice1, strToDouble);
		}
		
		//4 WILL ASK WHICH ACCOUNT TYPE THEY WOULD LIKE TO OPEN
		else if (answer.equals("4")) {
			System.out.println("Would you like to create a 1)Checking or 2)Savings account?");
			System.out.println("(Please enter numerical answers only i.e. 1 or 2)");
			String choice = input.nextLine();
			if (choice.equals("1")) {
				makeAccount(0);
			}
			else if (choice.equals("2")) {
				makeAccount(1);
			}
			else {
				System.out.println("Invalid input.\n");
				System.out.println("////////////////////\n");
				adminMenu(currentUser, currentAccount);
			}
		}
		
		//5 WILL ASK YOU TO SEARCH FOR WHICH CUSTOMER YOU ARE LOOKING FOR BY USERNAME OR NAME
		else if (answer.equals("5")) {
			System.out.println("Please enter the customer's username:");
			String choice = input.nextLine();
			Connection conn = jdbc.getConnection();
			String sql = "select * from \"InformationTable\" where \"USER_ID\" = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, choice);
			ResultSet rs = ps.executeQuery();
			User u = null;
			while(rs.next()) {
				u = new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));
				System.out.println(u.toString());
				checkBalances(rs.getInt(1));
			}
			System.out.println("If you want to delete this user, enter \"DELETE\", otherwise enter anything else to continue: ");
			System.out.println("NOTE: ADMINS! PLEASE DO NOT DELETE EACHOTHER!");
			String choice1 = input.nextLine();
			if (choice1.equals("DELETE")) {
				String sql1 = "delete from \"InformationTable\" where \"BANK_ACCOUNT_ID\" = ?";
				PreparedStatement ps1 = conn.prepareStatement(sql1);
				ps1.setInt(1, rs.getInt(1));
				ps1.executeQuery();
				
				//Comment this section out if you don't want to delete their accounts as well
				String sql2 = "delete from \"AccountTable\" where \"BANK_ACCOUNT_ID\" = ?";
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, rs.getInt(1));
				ps2.executeQuery();		
			}
			else {
				adminMenu(currentUser,currentAccount);
			}
		}
		//6 WILL LOG OUT
		else if (answer.equals("6")) {
			currentUser = "";
			currentAccount = 0;
			System.out.println("Successfully Logged Out.");
			ldi.welcomeScreen();
		}
		
		//USER INPUTS INVALID RESPONSE, RESTARTS
		else {
			System.out.println("Invalid input.\n");
			System.out.println("////////////////////\n");
			adminMenu(currentUser, currentAccount);
		}
		adminMenu(currentUser,currentAccount);
	}
	
	public List<Account> checkBalances(int id) throws SQLException {
		List<Account> balanceList = new ArrayList<Account>();
		Connection conn = jdbc.getConnection();
		String sql = "select * from \"AccountTable\" where \"BANK_ACCOUNT_ID\" = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Account acct = null;
		while(rs.next()) {
			acct = new Account(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getDouble(4));
			balanceList.add(acct);
		}
		System.out.println();
		System.out.println("Accounts: " + balanceList.toString());
		return balanceList;
	}
	
	public void deposit(int accountType, int accountNum, double depositAmount) throws SQLException {
		Connection conn = jdbc.getConnection();
		String sql = "select * from \"AccountTable\" where \"BANK_ACCOUNT_ID\" = ? "
				+ "and \"accttype\" = ? and \"acctnum\" = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, currentAccount);
		ps.setInt(2, accountType);
		ps.setInt(3, accountNum);
		ResultSet rs = ps.executeQuery();
		Account acct = null;
		int temp = 0;
		rs.next();
		try{
			acct = new Account(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getDouble(4));
			acct.setAmount(acct.getAmount() + depositAmount);
			String sql1 = "update \"AccountTable\" " +
                "set \"amount\" = ? where \"BANK_ACCOUNT_ID\" = ? and \"accttype\" = ? and \"acctnum\" = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setDouble(1, acct.getAmount());
			ps1.setInt(2, acct.getAccountId());
			ps1.setInt(3, acct.getAccountType());
			ps1.setInt(4, acct.getAccountNum());
			ps1.execute();
			temp = 1;
		}
		finally {
			if (temp == 0) {
				System.out.println("There was an error in your inputs; sending back to main menu...");
				adminMenu(currentUser, currentAccount); 
			}
			else {
				System.out.println("You successfully deposited $" + depositAmount + ".");
				adminMenu(currentUser, currentAccount); 
			}
		}
	}
	
	public void withdraw(int accountType, int accountNum, double withdrawAmount) throws SQLException {
		Connection conn = jdbc.getConnection();
		String sql = "select * from \"AccountTable\" where \"BANK_ACCOUNT_ID\" = ? "
				+ "and \"accttype\" = ? and \"acctnum\" = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, currentAccount);
		ps.setInt(2, accountType);
		ps.setInt(3, accountNum);
		ResultSet rs = ps.executeQuery();
		Account acct = null;
		int temp = 0;
		rs.next();
		try{
			acct = new Account(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getDouble(4));
			if((acct.getAmount() - withdrawAmount) >= 0) {
				acct.setAmount(acct.getAmount() - withdrawAmount);
				String sql1 = "update \"AccountTable\" " +
                "set \"amount\" = ? where \"BANK_ACCOUNT_ID\" = ? and \"accttype\" = ? and \"acctnum\" = ?";
				PreparedStatement ps1 = conn.prepareStatement(sql1);
				ps1.setDouble(1, acct.getAmount());
				ps1.setInt(2, acct.getAccountId());
				ps1.setInt(3, acct.getAccountType());
				ps1.setInt(4, acct.getAccountNum());
				ps1.execute();
				temp = 1;
			}
			else {
				System.out.println("You do not have enough funds to withdraw that much");
				return;
			}
		}
		finally { 
			if (temp == 0) {
				System.out.println("There was an error in your inputs; sending back to main menu...");
				adminMenu(currentUser, currentAccount); 
			}
			else {
				System.out.println("You successfully withdrew $" + withdrawAmount + ".");
				adminMenu(currentUser, currentAccount); 
			}
		}
	}
	
	public void makeAccount(int newAccountType) throws SQLException {
		System.out.println(currentAccount);
		howManyAccounts(currentAccount, newAccountType);
		Connection conn = jdbc.getConnection();
		String sql = "insert into \"AccountTable\" values(?,?,?,0.00)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, currentAccount);
		ps.setInt(2, newAccountType);
		ps.setInt(3, howManyAccounts + 1);
		ps.executeUpdate();
		System.out.println("Account Successfully Created! Sending Back to Welcome Screen to Login...\n");
		System.out.println("////////////////////\n");
		howManyAccounts = 0;
		adminMenu(currentUser, currentAccount);
	}
	
	public void howManyAccounts(int currentAccount, int currentAccountType) throws SQLException {
		List<Account> numOfAccounts = new ArrayList<Account>();
		Connection conn = jdbc.getConnection();
		String sql = "select * from \"AccountTable\" where \"BANK_ACCOUNT_ID\" = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, currentAccount);
		ResultSet rs = ps.executeQuery();
		Account acct = null;
		while(rs.next()) {
			if(rs.getInt(2) == currentAccountType) {
				acct = new Account(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getDouble(4));
				numOfAccounts.add(acct);
			}	
		}
		howManyAccounts = numOfAccounts.size();
	}
	
}