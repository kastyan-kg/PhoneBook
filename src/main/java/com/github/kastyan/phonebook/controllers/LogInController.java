package com.github.kastyan.phonebook.controllers;



import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.kastyan.phonebook.classes.LoginRequest;
import com.github.kastyan.phonebook.classes.User;



@Controller
public class LogInController {
	
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public ModelAndView logIn(HttpServletRequest req){
		LoginRequest loginRequest = new LoginRequest();
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		final ModelAndView mav =  new ModelAndView("/login");
		mav.addObject("user", user);
		mav.addObject("loginRequest", loginRequest);
		
		return mav;
	}
	
	
	@RequestMapping(value ="/logincheck", method = RequestMethod.POST)
	public  ModelAndView loginCheck(@ModelAttribute("LoginRequest") LoginRequest loginRequest, HttpServletRequest req) throws ClassNotFoundException, SQLException{
		String login = loginRequest.getLogin();
		String password = loginRequest.getPassword();
		loginRequest.checkLogAndPass(login, password);
		HttpSession session = req.getSession();
		User user = new User();
		user.setName(login);
		session.setAttribute("user", user);
		ModelAndView mav = new ModelAndView("redirect:/index");
		mav.addObject("user", user);
		
		return mav;
	}
	@RequestMapping(value ="/logout", method = RequestMethod.GET)
	public ModelAndView logOut(HttpServletRequest req, HttpServletResponse resp){
		
		HttpSession httpSession = req.getSession();
		httpSession.invalidate();
		
		return new ModelAndView("redirect:/index");
	}
	
	
	

}
