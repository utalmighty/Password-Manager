package com.PasswordManager.Spring.DAO;

import java.util.List;

import com.PasswordManager.Spring.Entity.Password;

public interface PasswordDAO {
	void addPassword(Password password);
	void deletePassword(int id);
	void updatePassword(Password tempPassword);
	List<Password> getPasswordByUrl(String Url);
	List<String> getUrlPatterns();
	Password getPasswordById(int id);
	List<Password> getPasswords();
}
