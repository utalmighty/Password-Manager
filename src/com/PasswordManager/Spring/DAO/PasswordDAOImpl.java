package com.PasswordManager.Spring.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.PasswordManager.Spring.Entity.Password;

//@Repository
public class PasswordDAOImpl implements PasswordDAO {
	
	static String hibernateConfigFile = "hibernate.cfg.xml";
	
	@Override
	public void addPassword(Password password) {
		SessionFactory factory = new Configuration().configure(hibernateConfigFile).
				addAnnotatedClass(Password.class).
				buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
		
			session.save(password);
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

	@Override
	public void deletePassword(int id) {
		SessionFactory factory = new Configuration().configure(hibernateConfigFile).
				addAnnotatedClass(Password.class).
				buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
		
			Password tempPassword = session.get(Password.class, id);
			session.delete(tempPassword);
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

	@Override
	public void updatePassword(Password tempPassword) {
		// TODO : Still to implement.
	}

	@Override
	public List<Password> getPasswords() {
		SessionFactory factory = new Configuration().configure(hibernateConfigFile).
				addAnnotatedClass(Password.class).
				buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Password> passwords = null;
		try {
			session.beginTransaction();
		
			 passwords = session.createQuery("from Password").getResultList();
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
		return passwords;
	}

	@Override
	public List<Password> getPasswordByUrl(String Url) {
		SessionFactory factory = new Configuration().configure(hibernateConfigFile).
				addAnnotatedClass(Password.class).
				buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Password> passwords = null;
		try {
			session.beginTransaction();
		
			String HQL = "from Password where Password.urlPattern="+Url;
			passwords = session.createQuery(HQL).getResultList();
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
		return passwords;
	}

	@Override
	public Password getPasswordById(int id) {
		SessionFactory factory = new Configuration().configure(hibernateConfigFile).
				addAnnotatedClass(Password.class).
				buildSessionFactory();
		Session session = factory.getCurrentSession();
		Password password = null;
		try {
			session.beginTransaction();
		
			password = session.get(Password.class, id);
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
		return password;
	}

	@Override
	public List<String> getUrlPatterns() {
		// TODO Auto-generated method stub
		return null;
	}

}
