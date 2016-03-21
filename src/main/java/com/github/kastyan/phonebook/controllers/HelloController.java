package com.github.kastyan.phonebook.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class HelloController {
	
	@RequestMapping("/index")
    public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("home");
	       
		return mav;
    }

}
