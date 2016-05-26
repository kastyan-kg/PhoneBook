package com.github.kastyan.phonebook.classes;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.kastyan.phonebook.utility.DigestPassword;

import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {
	private String name = "guest" ;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		DigestPassword util = new DigestPassword();
		String digestedPassword = util.digestPass(password);
		System.out.println(digestedPassword);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
		stmt = conn.createStatement();
		String sql = "INSERT INTO users(login, pass, fullname)  VALUES" + "('" + login + "','" + digestedPassword + "','" + fullName + "');";
		stmt.executeUpdate(sql);
		                    
		return true;
	}else{
		System.out.println("Sorry, try another login, this already exisits!");
		
		return false;
	}
	

}
public boolean checkLogAndPass(String login, String password) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException{
	DigestPassword util = new DigestPassword();
	String digestedPassword = util.digestPass(password);
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	Statement stmt = null;
	conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
	String sql = "SELECT login, pass FROM USERS  WHERE login = '" + login + "'";
	stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	String loginfromBase = "";
	String passFromBase = "";
	while(rs.next()) {
           loginfromBase = rs.getString("login");
           passFromBase = rs.getString("pass");
      }
	;
	
	if(loginfromBase.equals(login) && passFromBase.equals(digestedPassword)){
		System.out.println("haliluya!");
		return true;
	}else{
		return false;
	}
	

	
	
}
}
