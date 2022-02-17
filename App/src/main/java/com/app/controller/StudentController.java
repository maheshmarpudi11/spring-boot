package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String welcomePage() {
		return "Welcome to student services.";
	}
	
	@GetMapping("/students")
	public ResponseEntity getStudentList() {
		List studentList = studentService.getStudentList();
		return new ResponseEntity(studentList, HttpStatus.OK);
	}
	
	@PostMapping("/createStudent")
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		String message = studentService.saveStudentDetails(student);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);	
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<Student> updateStudentDetails(@RequestBody Student student) {
		Student studentResponse	= studentService.updateStudentDetails(student);
		return new ResponseEntity<Student>(studentResponse, HttpStatus.OK);
	}
	
	// http://localhost:8080/update?name=raju   : query params
	// http://localhost:8080/deleteStudent/105  : path variables
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id) {
		String message	= studentService.deleteStudent(id);
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}
	

}
