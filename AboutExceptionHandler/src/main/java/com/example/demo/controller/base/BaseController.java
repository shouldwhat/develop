package com.example.demo.controller.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.ServiceException;

//@ControllerAdvice			// extend 또는 @ControllerAdvice 사용
public class BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
	
	@ExceptionHandler(ServiceException.class)
	public Map<String, Object> catchServiceException(HttpServletRequest request, ServiceException e) {
		
		LOG.debug("ServiceException catched !");
		return this.makeResponseBody(request, e);
	}
	
	@ExceptionHandler(Exception.class)
	public Map<String, Object> catchException(HttpServletRequest request, Exception e) {
		
		LOG.debug("Exception catched !");
		return this.makeResponseBody(request, e);
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public void catchArithmeticException() {
		LOG.debug("ArithmeticException catched");
	}
	
	private Map<String, Object> makeResponseBody(HttpServletRequest request, Exception e) {
		
		Map<String, Object> output = new HashMap<>();
		output.put("message", e.getMessage());
		if(e instanceof ServiceException) {
			output.put("code", ((ServiceException) e).getCode());
		}
		
		return output;
	}
}
