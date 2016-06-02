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

import com.github.kastyan.phonebook.classes.Contact;
import com.github.kastyan.phonebook.classes.LoginRequest;
import com.github.kastyan.phonebook.classes.User;





@Controller
public class IndexController {
	
	@Autowired
	private User user;

	@RequestMapping(value ="/index", method = RequestMethod.GET)
    public ModelAndView index() {
		
		final ModelAndView mav =  new ModelAndView("/index");
		
		mav.addObject("contact", new Contact());
		mav.addObject("user", this.user);
        return mav;
    }
	@RequestMapping(value = "/addingcontact", method = RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute("Contact") Contact contact) throws ClassNotFoundException, SQLException{
		final ModelAndView mav = new ModelAndView("redirect:/index");
		
		//contact = new Contact();
		/*String surname = contact.getSurname();
		String name = contact.getName();
		String fathersName = contact.getFathersName();
		String cellPhone = contact.getCellPhone();
		String phone = contact.getPhone();
		String addres = contact.getAddres();
		String email = contact.getEmail();*/
		//contact.set
		System.out.println(contact.getSurname());
		//contact.addContact(contact);
		mav.addObject("user", this.user);
		return mav;
		
		
	}
    

}