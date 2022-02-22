package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.entity.User;

@Controller
@SessionAttributes(value = "activeUser")
public class LoginController {

	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
		
	}

	@PostMapping("/login")
	public String loginCheck(User user, Model model) {
		
		if(user != null && user.getUsername().equals(user.getPassword())) {
			model.addAttribute("activeUser", user.getUsername());
			return "home";
		}
		
		model.addAttribute("message","invalid username/password.");
		model.addAttribute("user",new User());
		return "login";
	}
	
}
