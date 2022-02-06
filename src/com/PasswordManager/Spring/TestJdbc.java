package com.PasswordManager.Spring;

import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/password_manager?useSSL=false&serverTimezone=UTC";
		String user = "defeat_the_hunger";
		String pass = "defeat_the_hunger";
		try {
			System.out.println("Connecting to database");
			DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connected to database");
		}
		catch (Exception e) {
			System.out.println("ERROR >>"+e);
		}
	}

}
