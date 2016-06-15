package com.github.kastyan.phonebook.controllers;



import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.github.kastyan.phonebook.DAO.UserDAO;
import com.github.kastyan.phonebook.classes.LoginRequest;
import com.github.kastyan.phonebook.classes.User;



@Controller
public class LogInController {
	@Autowired
	private User user;
	@Autowired
	private UserDAO userDAO;
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public ModelAndView logIn(){
		LoginRequest loginRequest = new LoginRequest();
		final ModelAndView mav =  new ModelAndView("/login");
		mav.addObject("user", user);
		mav.addObject("loginRequest", loginRequest);
		return mav;
	}
	
	
	@RequestMapping(value ="/logincheck", method = RequestMethod.POST)
	public  ModelAndView loginCheck(@ModelAttribute("LoginRequest") LoginRequest loginRequest) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException{
		String login = loginRequest.getLogin();
		String password = loginRequest.getPassword();
		ModelAndView mav = null;
		if(userDAO.checkLogAndPass(login, password)){
			user.setName(login);
			int idFromDB = userDAO.getUserIDFromDB(login);
			user.setUserId(idFromDB);
			mav = new ModelAndView("redirect:/index");
		}else{
			mav = new ModelAndView("redirect:/login");
		}
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
