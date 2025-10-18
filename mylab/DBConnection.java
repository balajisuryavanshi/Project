package com.mylab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String url="jdbc:mysql://localhost:3306/library";   
	private static final String user="root";
	private static final String password="root";
	
	public static Connection getConnection() throws SQLException 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.out.println("mysql jdbc driver not found");
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		
	}

}
