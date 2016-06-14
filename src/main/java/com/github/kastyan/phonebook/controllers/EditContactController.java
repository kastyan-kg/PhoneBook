package com.github.kastyan.phonebook.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.kastyan.phonebook.DAO.ContactDAO;



@Controller
public class EditContactController {
	@RequestMapping(value ="/editcontact/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable   int id) 
			throws ClassNotFoundException, SQLException{
		ContactDAO dao = new ContactDAO();
		
		System.out.println("delete " + id);
		dao.deleteContact(id);
		
		return new ModelAndView("redirect:/index");
		
	}
	
}
