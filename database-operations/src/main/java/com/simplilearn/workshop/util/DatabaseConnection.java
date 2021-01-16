package com.simplilearn.workshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private Connection connection;
	
	public DatabaseConnection(String url , String user, String password) throws ClassNotFoundException, SQLException {
		// load driver class
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(url,user,password);
	}
	
	
	public Connection getConnection() {
		return connection;
	}
	
	public void closeConnection() throws SQLException{
		if(this.connection != null) {
			this.connection.close();
		}
	}

}
