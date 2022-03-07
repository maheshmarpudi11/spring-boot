package com.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyException extends ResponseEntityExceptionHandler{
	
	  @ExceptionHandler(UserNotFoundException.class) 
	  public ResponseEntity<String> userNotFoundException(UserNotFoundException e){ 
		  return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND); 
	  }
	  
	  
	  @ExceptionHandler(Exception.class) 
	  public ResponseEntity<String> allExceptionHandler(Exception e){ 
		  return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); 
	  }
	 
}
