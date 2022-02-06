package com.PasswordManager.Spring.Service;

import java.util.List;

import com.PasswordManager.Spring.Entity.Password;

public interface PasswordServiceInterface {

	void addPassword(Password password);
	void deletePassword(int id);
	void updatePassword(Password tempPassword);
	List<Password> getPasswordByUrl(String Url);
	List<String> getUrlPatterns();
	Password getPasswordById(int id);

	//here we have same methods as of DAO because we dont need other than that for our current project
	// we can simply delegate to passwordDAO.
	// but here we have removed getPasswords() because we dont need it
}

