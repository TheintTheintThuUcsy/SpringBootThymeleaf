package com.java.testing.Thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		if(!user.getName().isEmpty() && !user.getEmail().isEmpty()) {
			modelAndView.setViewName("user-data");
			modelAndView.addObject("user",user);
		}else {
			modelAndView.setViewName("index");
			modelAndView.addObject("message","Enter data");
		}
		return modelAndView;
	}
}
