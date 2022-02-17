package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Value("${student.school}")
	private String school;
	
	static Map<Integer,Student> studentMap;
	static {
		studentMap = new HashMap();
		studentMap.put(101, new Student(101, "Mahesh", "hyderbad"));
		studentMap.put(102, new Student(102, "ravi", "chennai"));
		studentMap.put(103, new Student(103, "Mahesh", "hyderbad"));
	}
	
	
	public List getStudentList() {
		
		/*
		 * List responseList = new ArrayList<>();
		 * 
		 * for(Map.Entry<Integer,Student> entry: studentMap.entrySet()) {
		 * responseList.add(entry.getValue()); }
		 */		
		List studentList = studentRepo.findAll();
		
		return studentList;
	}


	public String saveStudentDetails(Student student) {
	
		//studentMap.put(student.getId(), student);
		
		//Student responseStudent = (Student) studentMap.get(student.getId());
		
		student.setSchool(school);
		studentRepo.save(student);
		
		
		return "Student is saved with id :"+student.getId();
	}


	public Student updateStudentDetails(Student student) {
		
		if(studentMap.containsKey(student.getId())) {
			studentMap.put(student.getId(),student);
		}
		
		Student updatedResponse = studentMap.get(student.getId());
		
		return updatedResponse;
	}


	public String deleteStudent(Integer id) {
		
		if(studentMap.containsKey(id)) {
			studentMap.remove(id);
			return "Student is delete with id :"+id;
		}
			
		return "Student is not avaliable with id :"+id;
		
	}

}
