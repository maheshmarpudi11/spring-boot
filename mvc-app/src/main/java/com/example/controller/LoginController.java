package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.example.security.User;

@Controller
@SessionAttributes(value = "activeUser")
public class LoginController {

	@Autowired
	public RestTemplate restTemplate;
/*
	static Map<String, User> userMap;
	static {
		userMap = new HashMap<String, User>();
		userMap.put("admin", new User("admin", "admin"));
		userMap.put("test", new User("test", "test123"));
	}

	public static boolean validateUser(User user) {

		User currentUser = userMap.get(user.getUsername());

		if (currentUser != null && currentUser.getUsername() != null && currentUser.getPassword() != null) {
			user.getPassword().equals(currentUser.getPassword());
			return true;
		}

		return false;
	}

*/	
	@GetMapping("/")
	public String loadLoginPage(Model model) {

		model.addAttribute("user", new User());

		return "login";
	}
	
	@PostMapping("/login")
	public String userLogin(@Valid User user,BindingResult results, Model model) {
		System.out.println("userLogin method..");
		if(results.hasErrors()) {
			System.out.println(results.hasErrors());
			return "login";
		}
		
		if(!(user != null && user.getPassword() !=null && user.getUsername() != null )) {
			model.addAttribute("message", "invalid username/password.");
			model.addAttribute("user", new User());
			return "login";
		}
		
		//Student[] students = restTemplate.getForObject("http://localhost:9090/students", Student[].class);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic dXNlcjpwYXNzd29yZA==");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity reponse = restTemplate.exchange("http://localhost:9090/students", HttpMethod.GET, entity,Student[].class);
		
		//System.out.println(students[0].toString());
		model.addAttribute("student", new Student());
		model.addAttribute("students", reponse.getBody());
		model.addAttribute("activeUser", user.getUsername());

		return "home";
	}

	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveStudent(Student student, Model model) {
		System.out.println("calling post service..");
		restTemplate.postForObject("http://localhost:9090/createStudent", student, String.class);
		Student[] students = restTemplate.getForObject("http://localhost:9090/students", Student[].class);

		model.addAttribute("student", new Student());
		model.addAttribute("students", students);

		return "home";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") String studentId, Model model) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", studentId);

		restTemplate.delete("http://localhost:9090/deleteStudent/{id}", params);

		Student[] students = restTemplate.getForObject("http://localhost:9090/students", Student[].class);

		model.addAttribute("student", new Student());
		model.addAttribute("students", students);

		return "home";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateStudent(@PathVariable("id") int studentId, Model model) {

		Student[] students = restTemplate.getForObject("http://localhost:9090/students", Student[].class);
		Student updateStudent = restTemplate.getForObject("http://localhost:9090/getStudent/" + studentId,
				Student.class);

		model.addAttribute("student", updateStudent);
		model.addAttribute("students", students);

		return "home";
	}

}
