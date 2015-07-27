package com.sudarshan.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class GenericHandlerExceptionResolver extends
		SimpleMappingExceptionResolver {
	
	public GenericHandlerExceptionResolver() {
		setWarnLogCategory(getClass().getName());
	}
	
	@Override
	protected String buildLogMessage(Exception ex, HttpServletRequest request) {
		return "Spring MVC exception: " + ex.getLocalizedMessage();
	}
	
	@Override
	protected ModelAndView getModelAndView(String viewName, Exception ex,
			HttpServletRequest request) {


		ModelAndView modelAndView = super.getModelAndView(viewName, ex, request);
		
		modelAndView.addObject("url", request.getRequestURL());
		
		return modelAndView;
	}
	
}
