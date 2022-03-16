package com.example.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController  {

	//Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        System.out.println(status.toString());
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
        
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
            	model.addAttribute("message","Unable access service URL / File Not Found Exception..");
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            	model.addAttribute("message","Unable access Application, Please Check with Admin.");
                return "error-500";
            }
        }
        model.addAttribute("message","Unable process Request check with Admin");
        return "error";
    }

	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
   
}