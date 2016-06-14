package com.github.kastyan.phonebook.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.github.kastyan.phonebook.App;

public class Contact {
	private int id;
	private String surname;
	private String name;
	private String fathersname;
	private String cellphone;
	private String phone;
	private String addres;
	private String email;
	
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(int id, String surname, String name, String fathersname, String cellphone, String phone,
			String addres, String email) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.fathersname = fathersname;
		this.cellphone = cellphone;
		this.phone = phone;
		this.addres = addres;
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getFathersname() {
		return fathersname;
	}

	public void setFathersname(String fathersname) {
		this.fathersname = fathersname;
	}

	public String getCellphone() {
		return cellphone;
	}
	
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
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


	public void addContact(Contact newContact, int userID) throws ClassNotFoundException, SQLException{

		this.name = newContact.name;
		this.surname = newContact.surname;
		this.fathersname = newContact.fathersname;
		this.cellphone = newContact.cellphone;
		this.phone = newContact.phone;
		this.addres = newContact.addres;
		this.email = newContact.email;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
		stmt = conn.createStatement();
		String sql = "INSERT INTO phones(surname, name, fathersName, cellPhone, phone, addres, email, id_user )  "
		+ "VALUES" + "('" + surname + "','" + name + "','" + fathersname + "','"+
	    cellphone + "','" + phone + "','" + addres + "','" + email + "','" + userID + "'" + ");";
		stmt.executeUpdate(sql);
	}
	
	
}
