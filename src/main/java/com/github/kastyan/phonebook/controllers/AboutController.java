package com.github.kastyan.phonebook.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.kastyan.phonebook.classes.User;

@Controller
public class AboutController {
	@Autowired
	private User user;
	@RequestMapping("/about")
	public ModelAndView about(HttpServletRequest req){
		//HttpSession session = req.getSession();
		//User user = (User)session.getAttribute("user");
		final ModelAndView mav =  new ModelAndView("/about");
		mav.addObject("user", user);
		return mav;
		
	}

}
