package com.sudarshan.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest req, Exception exp) throws Exception {
		 // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
		if(AnnotationUtils.findAnnotation(exp.getClass(), ResponseStatus.class)!=null){
			throw exp;
		}
		return "error";
	}
	
	
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest req, Exception exp) {
		return "database_error";
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException() {
		System.out.println("IOEXception Occured");
	}
	
}
