package com.PasswordManager.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PasswordManager.Spring.DAO.PasswordDAO;
import com.PasswordManager.Spring.Entity.Password;

@Service
public class PasswordServiceImpl implements PasswordServiceInterface{


	@Autowired
	private PasswordDAO passwordDao; 
	
	@Override
	@Transactional
	public void addPassword(Password password) {
		passwordDao.addPassword(password);
	}

	@Override
	@Transactional
	public void deletePassword(int id) {
		passwordDao.deletePassword(id);
		
	}

	@Override
	@Transactional
	public void updatePassword(Password tempPassword) {
		passwordDao.updatePassword(tempPassword);
		
	}

	@Override
	@Transactional
	public List<Password> getPasswordByUrl(String Url) {
		return passwordDao.getPasswordByUrl(Url);
	}

	@Override
	@Transactional
	public List<String> getUrlPatterns() {
		return passwordDao.getUrlPatterns();
	}

	@Override
	@Transactional
	public Password getPasswordById(int id) {
		return passwordDao.getPasswordById(id);
	}

}
