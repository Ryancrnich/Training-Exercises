package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	//Singleton Factory
	
	//private static instance of itself
	private static ConnFactory cf = new ConnFactory();
	
	//private no args constructor
	private ConnFactory() {
		super();
	}
	
	//public static syncronized "getter" method
	public static synchronized ConnFactory getInstance() {
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	
	//Methods that do stuff
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
//		String url = "jdbc:postgresql://dbbenright.cviba8ddmknh.u"
//		+ "s-east-2.rds.amazonaws.com/postgres";
//		String user = "benright313";
//		String pw = "awsDB313";
		try {
			prop.load(new FileReader("database.properties"));
			conn = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"), prop.getProperty("pw"));
		} catch (SQLException e) {
			System.out.println("Failed to create connection!");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}