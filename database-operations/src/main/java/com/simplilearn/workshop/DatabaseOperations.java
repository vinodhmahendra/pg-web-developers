package com.simplilearn.workshop;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.workshop.util.DatabaseConnection;

@WebServlet("/databaseoperations")
public class DatabaseOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();

			out.println("<html> <body>");
			out.println("<h1> Simplilearn Database Operation Example</h1>");
			out.println("<hr size=\"5\" color=\"blue\"/>");

			InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/jdbc.properties");

			Properties properties = new Properties();
			properties.load(inputStream);
			DatabaseConnection connection = new DatabaseConnection(properties.getProperty("url"),
					properties.getProperty("user"), properties.getProperty("password"));

			
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("create database mydatabase");
			out.println("created database : mydatabase </br>");
			
			statement.executeUpdate("use mydatabase");
			out.println("Selected Database : mydatabase </br>");
			
			statement.executeUpdate("drop database mydatabase");
			statement.close();
			out.println("Dropped database : mydatabase </br> ");
			
			out.println("</html> </body>");
			connection.closeConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
