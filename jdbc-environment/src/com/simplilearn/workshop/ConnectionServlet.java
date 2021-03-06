package com.simplilearn.workshop;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.workshop.util.DatabaseConnection;

public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html> <body>");
		
		try{
			InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/application.properties");
			
			
			Properties properties = new Properties();
			properties.load(inputStream);
			
			
			DatabaseConnection connection = 
					new DatabaseConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
			
			out.println("Database connection intialized . <br/>");
			
			connection.closeConnection();
			
			out.println("Databse Connection Closed <br/>");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		out.println("</html> </body>");
		out.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
