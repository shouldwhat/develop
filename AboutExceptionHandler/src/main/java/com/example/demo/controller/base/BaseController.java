package com.example.demo.controller.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.ServiceException;

public class BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
	
	@ExceptionHandler(ServiceException.class)
	public Map<String, Object> catchServiceException(HttpServletRequest request, ServiceException e) {
		
		LOG.debug("ServiceException catched !");
		return this.makeResponseBody(request, e);
	}
	
	private Map<String, Object> makeResponseBody(HttpServletRequest request, ServiceException e) {
		
		Map<String, Object> output = new HashMap<>();
		output.put("code", e.getCode());
		output.put("message", e.getMessage());
		
		return output;
	}

	@ExceptionHandler(Exception.class)
	public void catchException() {
		LOG.debug("Exception catched !");
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public void catchArithmeticException() {
		LOG.debug("ArithmeticException catched");
	}
}
