package com.sudarshan.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@Component
public class MyExceptionHandlerResolver extends ExceptionHandlerExceptionResolver {

	public 	MyExceptionHandlerResolver() {
		System.out.println("hurrayyyyyyyyyyyyyyyyyyyyyyyy");
		// Turn logging on by default
		setWarnLogCategory(getClass().getName());
		
		//Order of execution
		setOrder(Integer.MIN_VALUE);
	}
	
	
	@Override
	protected String buildLogMessage(Exception ex, HttpServletRequest request) {
		return "MVC Exception "+ex.getLocalizedMessage()+" having url "+request.getRequestURL();
	}
	
	
	@Override
	protected ModelAndView doResolveHandlerMethodException(
			HttpServletRequest request, HttpServletResponse response,
			HandlerMethod handlerMethod, Exception exp) {
		ModelAndView modelAndView = super.doResolveHandlerMethodException(request, response, handlerMethod, exp);
		System.out.println("handlerMethod "+handlerMethod);
		System.out.println("exp "+exp);
		System.out.println("modelAndView "+modelAndView);
		if(modelAndView!=null && modelAndView.hasView()){
			//System.out.println("yahoooooooooooooooooooooooooooo");
			modelAndView.addObject("obj1", "Inside ExceptionHandlerExceptionResolver");
			modelAndView.addObject("obj2", exp.getMessage());
		}
		/*
		System.out.println("modelAndView   outside "+modelAndView);
		*/
		
		return modelAndView;
	}
}
