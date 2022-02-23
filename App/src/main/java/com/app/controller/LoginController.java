package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.entity.User;

@Controller
@SessionAttributes(value = "activeUser")
public class LoginController {
	
	static Map<String,User> userMap;
	static{
		userMap = new HashMap<String,User>();
		userMap.put("admin", new User("admin","admin"));
		userMap.put("test", new User("test","test123"));
	}
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
		
	}

	@PostMapping("/login")
	public String loginCheck(@Valid User user,BindingResult results,Model model) {
		
		if(results.hasErrors()) {
			return "login";
		}
		
		if(!validateUser(user)) {
			model.addAttribute("message", "invalid username/password.");
			return "login";
		}
		
		model.addAttribute("activeUser", user.getUsername());
		return "home";
	
	}

	public static boolean validateUser(User user) {
		
		User currentUser = userMap.get(user.getUsername());
		
		if(currentUser!=null && currentUser.getUsername()!=null && currentUser.getPassword() != null) {
			user.getPassword().equals(currentUser.getPassword());
			return true;
		}
		
		return false;
	}
	
}
