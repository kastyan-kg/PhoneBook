package com.github.kastyan.phonebook.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Contact {
	private String surname;
	private String name;
	private String fathersName;
	private String cellPhone;
	private String phone;
	private String addres;
	private String email;
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addContact(Contact newContact) throws ClassNotFoundException, SQLException{
		this.name = newContact.name;
		this.surname = newContact.surname;
		this.fathersName = newContact.fathersName;
		this.cellPhone = newContact.cellPhone;
		this.phone = newContact.phone;
		this.addres = newContact.addres;
		this.email = newContact.email;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
		stmt = conn.createStatement();
		String sql = "INSERT INTO users(surname, name, fathersName, cellPhone, phone, addres, email )  "
		+ "VALUES" + "('" + surname + "','" + name + "','" + fathersName + "'"+
	    cellPhone + "','" + phone + "','" + addres + "','" + email + "'" + ");";
		stmt.executeUpdate(sql);
	}
	public List showContacts(int userID){
		
		
		
		return null;
	}
}
