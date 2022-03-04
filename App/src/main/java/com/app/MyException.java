package com.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyException{
	
	  @ExceptionHandler(UserNotFoundException.class) 
	  public ResponseEntity<String> userNotFoundException(UserNotFoundException e){ 
		  return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND); 
	  }
	 
}
