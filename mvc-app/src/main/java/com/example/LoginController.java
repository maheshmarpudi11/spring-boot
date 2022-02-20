package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	static Map<String,Student> studentsMap = null;
	
	static {
		studentsMap = new HashMap<String,Student>();
		studentsMap.put("101",new Student(101, "Mahesh","Hyderabad"));
		studentsMap.put("102",new Student(102, "Manoj","Hyderabad"));
		
	}
	
	
	@GetMapping("/")
	public String loadLoginPage(Model model) {
		
		model.addAttribute("user",new User());
		
		return "login";
	}
	
	@PostMapping("/userLogin")
	public String userLogin(User user, Model model) {
		
		if(user.getUsername()!= null && user.getUsername().equals(user.getPassword())) {
			
			model.addAttribute("student",new Student());
			
			List<Student> students = new ArrayList<Student>();; 
			
			for( Map.Entry<String,Student> entry :studentsMap.entrySet()) {
				students.add(entry.getValue());
			}
			
			model.addAttribute("students", students);
				
			return "redirect:/home";
		}
		
		model.addAttribute("user",new User());
		model.addAttribute("message","user is invalid..");
		
		return "login";
	}
	

	@RequestMapping("/home")
	public String index(Model model) {
		model.addAttribute("student",new Student());
		
		List<Student> students = new ArrayList<Student>();; 
		
		for( Map.Entry<String,Student> entry :studentsMap.entrySet()) {
			students.add(entry.getValue());
		}
		
		model.addAttribute("students", students);
		
		return "home";
	}
	
	@RequestMapping(value={"save"}, method = RequestMethod.POST)
	public String saveStudent(Student student, Model model) {
		
		studentsMap.put(String.valueOf(student.getId()),student);
		
		List<Student> students = new ArrayList<Student>();; 
		
		for( Map.Entry<String,Student> entry :studentsMap.entrySet()) {
			students.add(entry.getValue());
		}
		
		model.addAttribute("student",new Student());
		model.addAttribute("students", students);
		
		return "home";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") String studentId, Model model) {
		
		studentsMap.remove(studentId);
		
		List<Student> students = new ArrayList<Student>();; 
		
		for( Map.Entry<String,Student> entry :studentsMap.entrySet()) {
			students.add(entry.getValue());
		}
		
		model.addAttribute("student",new Student());
		model.addAttribute("students", students);
		
		return "home";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateStudent(@PathVariable("id") String studentId, Model model) {
		
		Student updateStudent = studentsMap.get(studentId);
		
		List<Student> students = new ArrayList<Student>();; 
		
		for( Map.Entry<String,Student> entry :studentsMap.entrySet()) {
			students.add(entry.getValue());
		}
		
		model.addAttribute("student",updateStudent);
		model.addAttribute("students", students);
		
		return "home";
	}
	
	
	
	
	
	
}
