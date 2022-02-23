package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Entity
//@Table(name = "T_STUDENT")
public class Student {
	
	@Id
	private Integer id;
	private String name;
	private String address;
	private String school;

	public Student(Integer id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Student() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}
