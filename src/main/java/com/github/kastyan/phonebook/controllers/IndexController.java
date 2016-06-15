package com.github.kastyan.phonebook.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.kastyan.phonebook.DAO.ContactDAO;
import com.github.kastyan.phonebook.classes.Contact;
import com.github.kastyan.phonebook.classes.User;





@Controller
public class IndexController {
	
	@Autowired
	private User user;
	@Autowired
	private ContactDAO contactDAO;

	@RequestMapping(value ="/index", method = RequestMethod.GET)
    public ModelAndView index() throws ClassNotFoundException, SQLException {
		final ModelAndView mav =  new ModelAndView("/index");
		Contact contact = new Contact();
		mav.addObject("contact", contact);
		mav.addObject("user", this.user);
		System.out.println("User fields: " + user.getName() + user.getUserId());
		
		List<Contact> phonebook = contactDAO.showContacts(user.getUserId());
		mav.addObject("phonebook", phonebook);
        return mav;
    }
	
	
    

}