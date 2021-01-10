package com.simplilearn.workshop.util;

import java.sql.*;

public class DatabaseConnection {

	// create a reference for a Connection
	private Connection connection;
	
	//create a constructor
	public DatabaseConnection(String url , String user, String password) throws ClassNotFoundException, SQLException{
		// step #1 . load a JDBC Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//step #2 : obtain a Connection object to control database
		this.connection = DriverManager.getConnection(url, user, password);
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	
	public void closeConnection() throws SQLException {
		if (this.connection != null){
			this.connection.close();
		}
	}
}
