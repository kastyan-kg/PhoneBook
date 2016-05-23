package com.github.kastyan.phonebook.classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.github.kastyan.phonebook.utility.DigestPassword;


public class LoginRequest {
	
	private String login;
	private String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkLogAndPass(String login, String password) throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
		DigestPassword db = new DigestPassword();
		return true;
	}
	

}
