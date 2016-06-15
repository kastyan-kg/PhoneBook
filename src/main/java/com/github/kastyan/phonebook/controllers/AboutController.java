package com.github.kastyan.phonebook.controllers;

import javax.servlet.http.HttpServletRequest;
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
		final ModelAndView mav =  new ModelAndView("/about");
		mav.addObject("user", user);
		return mav;
		
	}

}
