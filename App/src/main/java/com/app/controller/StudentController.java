package com.app.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.UserNotFoundException;
import com.app.entity.Student;
import com.app.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/*
	 * @GetMapping("/") public String welcomePage() { return
	 * "Welcome to student services."; }
	 */
	
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
	
	@PutMapping(value="/updateStudent",produces = MediaType.APPLICATION_XML_VALUE )
	public ResponseEntity<Student> updateStudentDetails(@RequestBody Student student) {
		Student studentResponse	= studentService.updateStudentDetails(student);
		return new ResponseEntity<Student>(studentResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id) {
		String message	= studentService.deleteStudent(id);
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}
	
	@GetMapping("/students/{name}")
	public ResponseEntity<List<Student>> getStudentsWithName(@PathVariable("name") String name) {
		List<Student> studentList	= studentService.getStudentsWithName(name);
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
		
	}

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		Student student	= studentService.getStudentById(id);
		if(student == null) {
			System.out.println("getStudent if block.");
			throw new UserNotFoundException("Record not found with this student id : "+id);
		}
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
		
	}
	
	/*
	 * @ExceptionHandler(UserNotFoundException.class) public ResponseEntity<String>
	 * userNotFoundException(UserNotFoundException e){ return new
	 * ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND); }
	 */
	
	
}
