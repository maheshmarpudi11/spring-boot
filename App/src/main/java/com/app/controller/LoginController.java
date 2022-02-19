package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("message", "Welcome to Login Page");
		return "login";
	}

	@GetMapping("/login")
	public String loginCheck(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model) {

		if (username.equals(password)) {
			model.addAttribute("username", username);
			return "home";
		}

		model.addAttribute("message", "user is invaid..");
		return "login";
	}

}
