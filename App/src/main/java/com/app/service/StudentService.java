package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.app.entity.Student;

@Service
public class StudentService {

	static Map<Integer,Student> studentMap = null;
	static {
		studentMap = new HashMap();
		studentMap.put(101, new Student(101, "Mahesh", "hyderbad"));
		studentMap.put(102, new Student(102, "ravi", "chennai"));
		studentMap.put(103, new Student(103, "Mahesh", "hyderbad"));
	}
	
	
	public List getStudentList() {
		
		List responseList = new ArrayList<>();
		
		for(Map.Entry<Integer,Student> entry: studentMap.entrySet()) {
			responseList.add(entry.getValue());
		}
		
		return responseList;
	}


	public String saveStudentDetails(Student student) {
	
		studentMap.put(student.getId(), student);
		
		Student responseStudent = (Student) studentMap.get(student.getId());
		
		return "Student is saved with id :"+responseStudent.getId();
	}

}
