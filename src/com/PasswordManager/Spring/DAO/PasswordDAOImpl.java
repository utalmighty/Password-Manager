package com.PasswordManager.Spring.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.PasswordManager.Spring.Entity.Password;

@Repository
public class PasswordDAOImpl implements PasswordDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void savePassword(Password password) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(password);
	}

	@Override
	public void deletePassword(int id) {
		Session session = sessionFactory.getCurrentSession();
		Password password = session.get(Password.class, id);
		session.delete(password);
	}

	@Override
	public List<Password> getPasswordByUrl(String url) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String HQL = "from Password where urlPattern = :url";
		Query<Password> query = session.createQuery(HQL, Password.class);
		query.setParameter("url", url);
		List<Password> passwords = query.getResultList();
		return passwords;
	}
	
	@Override
	public Password getPasswordById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Password password = session.get(Password.class, id);
		
		return password;
	}

	@Override
	public List<Password> getPasswords() {
		Session session = sessionFactory.getCurrentSession();
		
		String HQL = "from Password";
		Query<Password> query = session.createQuery(HQL, Password.class);
		List<Password> passwords = query.getResultList();
		
		return passwords;
	}

	@Override
	public List<String> getUrlPatterns() {
		Session session = sessionFactory.getCurrentSession();
		
		String HQL = "SELECT distinct urlPattern from Password Order By urlPattern";
		Query<String> query = session.createQuery(HQL, String.class);
		List<String>  urls= query.getResultList();
		
		return urls;
	}
}
