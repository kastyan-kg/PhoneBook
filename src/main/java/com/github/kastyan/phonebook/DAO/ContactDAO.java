package com.github.kastyan.phonebook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.kastyan.phonebook.classes.Contact;

public class ContactDAO {
	
public List showContacts(int userID) throws ClassNotFoundException, SQLException{
		
		List<Contact> phonebook = new ArrayList<Contact>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
		stmt = conn.createStatement();
		String sql = "SELECT * FROM phones WHERE phones.id_user = " + userID +  ";";
		ResultSet rs = stmt.executeQuery(sql);
		Contact contactPhonebook = new Contact();
		 while(rs.next()){
			String name =  rs.getString("name");
		    String surname = rs.getString("surname");
			String fathersname = rs.getString("fathersname");
			String cellphone = rs.getString("cellphone");
			String phone =  rs.getString("phone");
			String addres =  rs.getString("addres");
		    String email = rs.getString("email");
			 phonebook.add(new Contact(name,surname,fathersname,cellphone,phone,addres,email));
			   
			             }
		for (Contact contact : phonebook) {
			System.out.println(contact.getName() + " ");
			System.out.println(contact.getEmail() + " ");
		}
		return phonebook;
	}
}