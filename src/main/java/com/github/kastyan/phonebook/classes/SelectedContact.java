package com.github.kastyan.phonebook.classes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SelectedContact {
	private int id;
	private String surname;
	private String name;
	private String fathersname;
	private String cellphone;
	private String phone;
	private String addres;
	private String email;
	public  void selectContact(Contact contact){
		this.id = contact.getId();
		this.name = contact.getName();
		this.surname = contact.getSurname();
		this.fathersname = contact.getFathersname();
		this.cellphone = contact.getCellphone();
		this.phone = contact.getPhone();
		this.addres = contact.getAddres();
		this.email = contact.getEmail();
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
