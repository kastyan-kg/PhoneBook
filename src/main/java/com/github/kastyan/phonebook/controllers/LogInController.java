package com.github.kastyan.phonebook.controllers;



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
	public ModelAndView logIn(){
		final ModelAndView mav =  new ModelAndView("/login");
		LoginRequest loginRequest = new LoginRequest();
		mav.addObject("loginRequest",loginRequest );
		return mav;
	}
	@RequestMapping(value ="/logout", method = RequestMethod.GET)
	public ModelAndView logOut(HttpServletRequest req, HttpServletResponse resp){
		final ModelAndView mav =  new ModelAndView("/login");
		HttpSession httpSession = req.getSession(true);
		httpSession.invalidate();
		LoginRequest loginrequest = new LoginRequest();
		mav.addObject("loginrequest",loginrequest );
		return mav;
	}
	
	@RequestMapping(value ="/logincheck", method = RequestMethod.POST)
	public  ModelAndView loginCheck(@ModelAttribute("LoginRequest") LoginRequest loginRequest, HttpServletRequest req){
		String login = loginRequest.getLogin();
		String password = loginRequest.getPassword();
		HttpSession session = req.getSession();
		User user = new User();
		user.setName(login);
		session.setAttribute("user", user);
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("user", user);
		
		return mav;
	}
	
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView  user(){
		
		return new ModelAndView("login", "command", new Login() );
		
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("SpringWeb")Login user, 
	   ModelMap model) {
	      model.addAttribute("login", user.getLogin());
	      model.addAttribute("password", user.getPassword());
	     
	      
	      return "index";
	   }*/
	

}
