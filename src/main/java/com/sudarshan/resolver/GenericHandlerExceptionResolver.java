package com.sudarshan.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class GenericHandlerExceptionResolver extends
		SimpleMappingExceptionResolver {
	
	@Override
	protected String buildLogMessage(Exception ex, HttpServletRequest request) {
		return "Spring MVC exception: " + ex.getLocalizedMessage();
	}
	
}
