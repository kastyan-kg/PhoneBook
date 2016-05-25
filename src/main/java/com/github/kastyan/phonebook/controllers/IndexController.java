package com.github.kastyan.phonebook.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.kastyan.phonebook.classes.User;





@Controller
public class IndexController {
	
	@Autowired
	private User user;

	@RequestMapping(value ="/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest req) {
		//HttpSession session = req.getSession();
		//String name = (String) session.getAttribute("name");
		//User user = (User)session.getAttribute("user");
		final ModelAndView mav =  new ModelAndView("/index");
		mav.addObject("user", this.user);
        return mav;
    }
    

}