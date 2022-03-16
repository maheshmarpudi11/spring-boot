package com.example.controller;

import java.net.ConnectException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(ConnectException.class)
	public String handleConnectException(ConnectException e, Model model) {
		model.addAttribute("message",e.getMessage());
		
		return "error";
	}
}
