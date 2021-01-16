package com.simplilearn.workshop;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.workshop.util.DatabaseConnection;

public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();

			out.println("<html> <body>");
			out.println("<h1> Simplilearn Stored Procedure Example</h1>");
			out.println("<hr size=\"5\" color=\"blue\"/>");

			InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/jdbc.properties");

			Properties properties = new Properties();
			properties.load(inputStream);
			DatabaseConnection connection = new DatabaseConnection(properties.getProperty("url"),
					properties.getProperty("user"), properties.getProperty("password"));

			CallableStatement callableStatement = connection.getConnection().prepareCall("{call add_product(?,?)}");
			callableStatement.setString(1, "Apple Product");
			callableStatement.setBigDecimal(2, new BigDecimal(190000.00));

			int result = callableStatement.executeUpdate();

			out.println("stored procedure has been executed <br>" + result);

			callableStatement.close();
			out.println("</html> </body>");
			connection.closeConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
