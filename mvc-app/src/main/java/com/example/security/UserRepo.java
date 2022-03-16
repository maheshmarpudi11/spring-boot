package com.example.security;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends CrudRepository<User, Integer>{
	
	@Query("select u from User u where u.username = :username")
	public User getUserByUsername(@Param("username") String username);

}
