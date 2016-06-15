package com.github.kastyan.phonebook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.github.kastyan.phonebook.classes.Contact;
@Component
public class ContactDAO {
	
public List<Contact> showContacts(int userID) throws ClassNotFoundException, SQLException{
		
		List<Contact> phonebook = new ArrayList<Contact>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
		stmt = conn.createStatement();
		String sql = "SELECT * FROM phones WHERE phones.id_user = " + userID +  ";";
		ResultSet rs = stmt.executeQuery(sql);
		
		 while(rs.next()){
			int id = rs.getInt("id");
			String name =  rs.getString("name");
		    String surname = rs.getString("surname");
			String fathersname = rs.getString("fathersname");
			String cellphone = rs.getString("cellphone");
			String phone =  rs.getString("phone");
			String addres =  rs.getString("addres");
		    String email = rs.getString("email");
			 phonebook.add(new Contact(id,name,surname,fathersname,cellphone,phone,addres,email));
			   
			             }
		
		return phonebook;
	}

public void deleteContact(int id) throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	Statement stmt = null;
	conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
	stmt = conn.createStatement();
	String sql = "DELETE FROM phones WHERE id = " + id + ";";
	stmt.executeUpdate(sql);
          }
public void addContact(Contact newContact, int userID) throws ClassNotFoundException, SQLException{

	String name = newContact.getName();
	String surname = newContact.getSurname();
	String fathersname = newContact.getFathersname();
	String cellphone = newContact.getCellphone();
	String phone = newContact.getPhone();
	String addres = newContact.getAddres();
	String email = newContact.getEmail();
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
public void updateContact(Contact newContact, int userID) throws ClassNotFoundException, SQLException{
	String name = newContact.getName();
	String surname = newContact.getSurname();
	String fathersname = newContact.getFathersname();
	String cellphone = newContact.getCellphone();
	String phone = newContact.getPhone();
	String addres = newContact.getAddres();
	String email = newContact.getEmail();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	Statement stmt = null;
	conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
	stmt = conn.createStatement();
	String sql = "INSERT  phones SET  surname = + " + surname + ", name = " + name + ", fathersName = " + fathersname + 
			", cellPhone = " + cellphone + ", phone = " + phone + ", addres = " + addres + ", email = " + email + ", "
					+ "id_user = " + userID +  ";"; 
	stmt.executeUpdate(sql);
}
public Contact selectContact(int userID) throws ClassNotFoundException, SQLException{
	Contact contact = new Contact();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	Statement stmt = null;
	conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?characterEncoding=UTF-8&useSSL=false","user", "1812");
	stmt = conn.createStatement();
	String sql = "SELECT * FROM phones WHERE id_user = " + userID;
	ResultSet rs = stmt.executeQuery(sql);
	 while(rs.next()){
		int id = rs.getInt("id");
		contact.setName(rs.getString("name"));
		contact.setSurname(rs.getString("surname"));
		contact.setFathersname(rs.getString("fathersname")); 
		contact.setCellphone(rs.getString("cellphone"));
		contact.setPhone(rs.getString("phone"));
		contact.setAddres(rs.getString("addres")); 
	    contact.setEmail(rs.getString("email"));
		 
		   
		             }
	return contact;
}
 }
