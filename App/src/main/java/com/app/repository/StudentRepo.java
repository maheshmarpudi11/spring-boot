package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	
	/*
	 * @Query("select s from Student s where s.name = ?1 and s.age = ?2") // JPQL
	 * public List<Student> getAllStudentwithName(String name, String age);
	 * 
	 * 
	 * @Query("select s from Student s where s.name = :name and s.address = :address"
	 * ) public List<Student> getAllStudentwithName1(@Param("name") String
	 * name1, @Param("age") String age1);
	 * 
	 * 
	 * @Query( nativeQuery = true,
	 * value="SELECT * FROM T_STUDENT  WHERE NAME = :name AND AGE = :age") public
	 * List<Student> getAllStudentwithName3(@Param("name") String
	 * name1, @Param("age") String age1);
	 * 
	 * //@
	 * Query("select s from Student s where s.name = :name and s.address = :address"
	 * ) List<Student> findByNameAndAddress(String name,String address);
	 */
}
