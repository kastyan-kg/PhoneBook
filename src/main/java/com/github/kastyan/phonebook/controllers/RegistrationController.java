package com.github.kastyan.phonebook.controllers;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.kastyan.phonebook.classes.LoginRequest;
import com.github.kastyan.phonebook.classes.RegisterRequest;
import com.github.kastyan.phonebook.classes.User;

@Controller
public class RegistrationController {
	
	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public ModelAndView registration(){
		RegisterRequest registerRequest = new RegisterRequest();
		final ModelAndView mav =  new ModelAndView("/register");
		mav.addObject("registerRequest", registerRequest);
		return mav;
	}
	@RequestMapping(value ="/registration", method = RequestMethod.POST)
	public  ModelAndView loginCheck(@ModelAttribute("RegisterRequest") RegisterRequest registerRequest, HttpServletRequest req) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException{
		String login = registerRequest.getLogin();
		String password = registerRequest.getPassword();
		String fullName = registerRequest.getFullName();
		String result = null;
		if(registerRequest.createUser(login, password, fullName)){
		result = "User" + login + "created succesfully";
		HttpSession session = req.getSession();
		User user = new User();
		user.setName(login);
		session.setAttribute("user", user);
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("user", user);
		mav.addObject("result", result);
		return mav;
		}else{
			result = "Sorry, try another login, that already exisits!";
			
			ModelAndView mav = new ModelAndView("redirect:/register");
			mav.addObject("result", result);
			
			return mav;
		}
		
	}
}
