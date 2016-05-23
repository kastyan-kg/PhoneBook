package com.github.kastyan.phonebook.classes;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.kastyan.phonebook.utility.DigestPassword;

public class RegisterRequest {
	
	private String login;
	private String password;
	private String fullName;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public boolean checkPossibleLogin(String login) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
		stmt = conn.createStatement();
		String sql = "SELECT login FROM users";
		ResultSet rs = stmt.executeQuery(sql);
		
	    while(rs.next()){
	    String PossibleLogin = rs.getString("login");
	    if(login.equals(PossibleLogin)){
	    	return false;
	    }
	    }
		return true;
	}
	public boolean createUser(String login, String password, String fullName) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException{
		
		if(checkPossibleLogin(login)){
			DigestPassword db = new DigestPassword();
			String digestedPassword = db.digestPass(password);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			Statement stmt = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
			stmt = conn.createStatement();
			String sql = "INSERT INTO users VALUES" + "('" + login + "','" + password + "','" + fullName + "');";
			stmt.executeUpdate(sql);
			
			return true;
			
			
		}else{
			System.out.println("Sorry, try another login, this already exisits!");
			
			return false;
		}
		
	
	}

}
