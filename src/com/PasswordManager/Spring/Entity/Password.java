package com.PasswordManager.Spring.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "password")
public class Password {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "identified_by")
	private String identifiedBy;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "url_pattern")
	private String urlPattern;
	
	@Column(name = "password")
	private String password;

	public Password(){}
	
	public Password(String identifiedBy, String username, String urlPattern, String password) {
		super();
		this.identifiedBy = identifiedBy;
		this.username = username;
		this.urlPattern = urlPattern;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIdentifiedBy() {
		return identifiedBy;
	}

	public void setIdentifiedBy(String identifiedBy) {
		this.identifiedBy = identifiedBy;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Password [id=" + id + ", identifiedBy=" + identifiedBy + ", username=" + username + ", urlPattern="
				+ urlPattern + ", password=" + password + "]";
	}
	
}
