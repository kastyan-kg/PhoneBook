package com.github.kastyan.phonebook.classes;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;


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


	
	
}
