package com.github.kastyan.phonebook.controllers;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.kastyan.phonebook.DAO.UserDAO;
import com.github.kastyan.phonebook.classes.RegisterRequest;
import com.github.kastyan.phonebook.classes.User;

@Controller
public class RegistrationController {
	@Autowired
	private User user;
	@Autowired
	private UserDAO userDAO;
	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public ModelAndView registration(){
		RegisterRequest registerRequest = new RegisterRequest();
		final ModelAndView mav =  new ModelAndView("/register");
		mav.addObject("user", user);
		mav.addObject("registerRequest", registerRequest);
		return mav;
	}
	@RequestMapping(value ="/registration", method = RequestMethod.POST)
	public  ModelAndView loginCheck(@ModelAttribute("RegisterRequest") RegisterRequest registerRequest) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException{
		String login = registerRequest.getLogin();
		String password = registerRequest.getPassword();
		String fullName = registerRequest.getFullName();
		ModelAndView mav = null;
		if(userDAO.createUser(login, password, fullName)){
			System.out.println("User" + login + "created succesfully");
		user.setName(login);
		mav = new ModelAndView("/index");
		mav.addObject("user", user);
		return mav;
		
		}else{
			System.out.println("Sorry, try another login, that already exisits!"); 
			mav = new ModelAndView("redirect:/register");
			return mav;
			
			
		}
		
	}
}
