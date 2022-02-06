package com.PasswordManager.Spring;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.PasswordManager.Spring.Entity.Password;

public class AddToDatabaseDemo {

static String hibernateConfigFile = "hibernate.cfg.xml";
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure(hibernateConfigFile).
				addAnnotatedClass(Password.class).
				buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Password pass = new Password("Utkarsh", "utalmighty", "google", "googlepassword");
			session.save(pass);
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
