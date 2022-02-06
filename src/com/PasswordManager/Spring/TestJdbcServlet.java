package com.PasswordManager.Spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "To test the jdbc connection", urlPatterns = { "/TestJdbcServlet" })
public class TestJdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/password_manager?useSSL=false&serverTimezone=UTC";
		
		String user = "defeat_the_hunger";
		String pass = "defeat_the_hunger";
		
		String driver = "com.mysql.jdbc.Driver";
		
		PrintWriter out = response.getWriter();
		try {
			
			out.println("Connecting to database at: "+ jdbcUrl);
			Class.forName(driver);
			DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("Connected to database");
		}
		catch (Exception e) {
			out.println("ERROR >>"+e);
		}
	}

}
