package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.AccountDao;
import com.revature.model.Account;
import com.revature.util.ConnFactory;

public class AccountDaoImpl implements AccountDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	public List<Account> getAllAccounts() throws SQLException {
		List<Account> accountsList = new ArrayList<Account>();
		//we grab the conn factory to ge the connection 
		Connection conn= cf.getConnection();
		
		//here we create the object for the sql statement 
		Statement stmt = conn.createStatement();
		//we assign the resultSet of the query to rs
		ResultSet rs = stmt.executeQuery("SELECT * FROM accounts");
		//we create a new album to assign the resultStream values from query
		Account a =null;
		//while loop to add new Album from each row
		while(rs.next()) {
			a = new Account(rs.getString(1), rs.getDouble(2), rs.getString(3));
			accountsList.add(a);
			
		}
		return accountsList;
	}

	public List<Account> getAccountByID(String acct_id) throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		//we grab the getConnection from the conn factory
		Connection conn= cf.getConnection();
		//sql statement we want to execute
		String sql = "SELECT * FROM accounts WHERE acct_id = ? ";
		
		//creating a prepared statement, safer than statement
		PreparedStatement ps = conn.prepareStatement(sql);

		//get int id, first param is index and 2nd id value.
		ps.setString(1, acct_id);
		
		//we assign the executeQuery to the ResultSet
		ResultSet rs = ps.executeQuery();

		Account a =null;
		while(rs.next()) {
			a = new Account(rs.getString(1), rs.getDouble(2), rs.getString(3));
			accountList.add(a);
			
		}
		return accountList;
	
	}

	public int createAccount(Account account) throws SQLException {
		// if executeUpdate work returns 1 that we assign to this
		int accountsCreated = 0;

		String sql = "INSERT INTO accounts(acct_id, balance, acct_type) VALUES (?, ?, ?)";

		Connection conn = cf.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, account.getId());
		ps.setDouble(2, account.getBalance());
		ps.setString(3, account.getType());

		accountsCreated = ps.executeUpdate();

		return accountsCreated;

	}


	public int updateAccount(Account account) throws SQLException {
		int accountsUpdated = 0;

		String sql = "UPDATE accounts " + " set balance = ?" + " WHERE acct_id = ? ";

		Connection conn = cf.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setDouble(1, account.getBalance());
		ps.setString(2, account.getId());
		
		return accountsUpdated;
	}
	
	public double getBalance(String acct_id) throws SQLException {
		double balance = 0;
		ResultSet rs = null;

		String sql = "SELECT * FROM accounts WHERE acct_id = ?";

		Connection conn = cf.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, acct_id);
		rs = ps.executeQuery();

		while (rs.next()) {
			balance = rs.getDouble("balance");
		}
		return balance;

	}

	/*
	 * public void insertAccount(Account a, User u) throws SQLException { Connection
	 * conn = cf.getConnection(); String sql = "Insert into accounts values(?,?,?)";
	 * 
	 * PreparedStatement ps = conn.prepareStatement(sql); //we set the name (String)
	 * index one and value then same ps.setInt(1, a.getId()); ps.setDouble(2,
	 * a.getBalance()); ps.setString(3, a.getType());
	 * 
	 * ps.executeUpdate();
	 * 
	 * String sql2 = "INSERT INTO user_accounts (username, acct_id) VALUES (?, ?)";
	 * 
	 * PreparedStatement ps2 = conn.prepareStatement(sql2); ps2.setInt(2,
	 * a.getId()); ps2.setString(1, u.getUsername()); ps2.executeUpdate();
	 * 
	 * }
	 */

}
