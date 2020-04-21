package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.base.BaseController;
import com.example.demo.exception.CustomException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.base.ExceptionInvokeService;

@RestController
public class TestController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private ExceptionInvokeService exceptionInvokeService;
	
	@RequestMapping(value = "/exception", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void invokeException(HttpServletRequest request) throws Exception {
		exceptionInvokeService.invokeException();
		LOG.debug("after exception");	// if invoke exception, not work this line
	}
	
	@RequestMapping(value = "/service-exception", method = RequestMethod.GET)
	public void invokeServiceException(HttpServletRequest request) throws Exception {
		exceptionInvokeService.invokeServiceException();
	}
	
	@RequestMapping(value = "/arithmetic-exception", method = RequestMethod.GET)
	public void invokeArithmeticException() throws Exception {
		exceptionInvokeService.invokeArithmeticException();
	}
	
	@RequestMapping(value = "/custom-exception", method = RequestMethod.GET)
	public void invokeCustomException(HttpServletRequest request) throws CustomException {
		throw new CustomException();
	}
	
	@RequestMapping(value = "/doSomething", method = RequestMethod.GET)
	public void doSomething(HttpServletRequest request) throws ServiceException {
		try {
			exceptionInvokeService.doSomething();
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/doOtherSomething", method = RequestMethod.GET)
	public Map<String, Object> doOtherSomething(HttpServletRequest request) {
		
		Map<String, Object> output = new HashMap<>();
		output.put("age", 28);
		output.put("name", "wkkim");
		return output;
	}
}
