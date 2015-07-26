package com.sudarshan.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sudarshan.exception.EmployeeNotFoundException;
import com.sudarshan.model.Employee;
import com.sudarshan.model.ExceptionJSONInfo;

@Controller
public class EmployeeController {
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String getEmployee(@PathVariable("id") int id, Model model) throws Exception {
		
		if(id==1) {
			throw new EmployeeNotFoundException(id);
		} else if (id==2) {
			throw new SQLException("SQLException for id "+id);
		} else if(id==3) {
			throw new IOException("IOException for id "+id);
		} else if(id==10) {
			System.out.println("Hello");
			Employee emp = new Employee();
			emp.setName("Sudarshan Reddy");
			emp.setId(id);
			model.addAttribute("emp", emp);
			return "home";
		} else {
			throw new Exception("Generic Exception with id "+id);
		}
		
	}
	
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest req, Exception exp) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exp);
		modelAndView.addObject("url", req.getRequestURL());
		
		modelAndView.setViewName("error");
		
		return modelAndView;
	}
	
	/*@ExceptionHandler(EmployeeNotFoundException.class)
	public @ResponseBody ExceptionJSONInfo handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
	     
	    ExceptionJSONInfo response = new ExceptionJSONInfo();
	    response.setUrl(request.getRequestURL().toString());
	    response.setMessage(ex.getMessage());
	     
	    return response;
	}*/
	
}
