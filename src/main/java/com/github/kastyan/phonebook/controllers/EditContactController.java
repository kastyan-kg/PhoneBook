package com.github.kastyan.phonebook.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.github.kastyan.phonebook.DAO.ContactDAO;
import com.github.kastyan.phonebook.classes.Contact;
import com.github.kastyan.phonebook.classes.SelectedContact;
import com.github.kastyan.phonebook.classes.User;



@Controller
public class EditContactController {
	@Autowired
	private User user;
	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private SelectedContact selectedContact;
	@RequestMapping(value ="/edit", method = RequestMethod.GET)
	public ModelAndView edit(){
		ModelAndView mav = new ModelAndView("/edit");
		Contact contact = new Contact();
		mav.addObject("contact", contact);
		mav.addObject("selectedContact", selectedContact);
		mav.addObject("user", user);
		return mav;
	}
	@RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editId(@PathVariable   int id) throws ClassNotFoundException, SQLException{
		System.out.println("int id " + id);
		selectedContact.selectContact(contactDAO.withdrawContactFromDB(id));
		System.out.println("selectedContact.getName()" + selectedContact.getName());
	
		ModelAndView mav = new ModelAndView("redirect:/edit");
		mav.addObject("selectedContact", selectedContact);
		return mav;
	}
	@RequestMapping(value ="/deletecontact/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable   int id) throws ClassNotFoundException, SQLException{
		contactDAO.deleteContact(id);
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value ="/updatecontact", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("Contact") Contact contact) throws ClassNotFoundException, SQLException{
		contactDAO.updateContact(contact, selectedContact.getId());
		return new ModelAndView("redirect:/index");
	}
	@RequestMapping(value = "/addingcontact", method = RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute("Contact") Contact contact) throws ClassNotFoundException, SQLException{
		final ModelAndView mav = new ModelAndView("redirect:/index");
		contactDAO.addContact(contact, user.getUserId());
		mav.addObject("user", this.user);
		return mav;
	}
	
}
