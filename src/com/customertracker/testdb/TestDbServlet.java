package com.customertracker.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "springstudent";
		String password = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?serverTimeZone=UTC";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection conn = null;
		try {
			PrintWriter out = response.getWriter();
			
			Class.forName(driver);
			
			out.println("Connecting to database...."+jdbcUrl);
			
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			conn.close();
			out.println("SUCCESSFULLY connected to database:"+jdbcUrl);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
