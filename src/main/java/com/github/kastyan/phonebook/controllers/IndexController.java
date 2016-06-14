package com.github.kastyan.phonebook.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.kastyan.phonebook.DAO.ContactDAO;
import com.github.kastyan.phonebook.classes.Contact;
import com.github.kastyan.phonebook.classes.ContactCurrent;
import com.github.kastyan.phonebook.classes.LoginRequest;
import com.github.kastyan.phonebook.classes.User;





@Controller
public class IndexController {
	
	@Autowired
	private User user;

	@RequestMapping(value ="/index", method = RequestMethod.GET)
    public ModelAndView index() throws ClassNotFoundException, SQLException {
		
		final ModelAndView mav =  new ModelAndView("/index");
		Contact contact = new Contact();
	
		mav.addObject("contact", contact);
		mav.addObject("user", this.user);
		ContactDAO phones = new ContactDAO();
		List phonebook = phones.showContacts(user.getUserId());
		mav.addObject("phonebook", phonebook);
        return mav;
    }
	@RequestMapping(value = "/addingcontact", method = RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute("Contact") Contact contact) throws ClassNotFoundException, SQLException{
		final ModelAndView mav = new ModelAndView("redirect:/index");
		
		System.out.println(contact.getSurname());
		contact.addContact(contact, user.getUserId());
		mav.addObject("user", this.user);
		
		return mav;
		
		
	}
	
    

}