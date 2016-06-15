package com.github.kastyan.phonebook.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.github.kastyan.phonebook.utility.DigestPassword;
@Component
public class UserDAO {
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
	if(loginfromBase.equals(login) && passFromBase.equals(digestedPassword)){
		System.out.println("haliluya!");
		return true;
	}else{
		return false;
	}
  }
    public int getUserIDFromDB(String login) throws ClassNotFoundException, SQLException{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn = null;
    	Statement stmt = null;
    	conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
    	String sql = "SELECT id FROM USERS  WHERE login = '" + login + "'";
    	stmt = conn.createStatement();
    	ResultSet rs = stmt.executeQuery(sql);
    	int idFromBase = 0;
    	while(rs.next()) {
               idFromBase = rs.getInt(1);
          }
		return idFromBase;
    	
    }

}
