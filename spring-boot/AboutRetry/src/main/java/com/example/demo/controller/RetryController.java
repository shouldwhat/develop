package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RetryService;

@RestController
public class RetryController {

	private static final Logger LOG = LoggerFactory.getLogger(RetryController.class);
	
	@Autowired
	private RetryService retryService;
	
	@GetMapping(value = "/get")
	public void get(HttpServletRequest request, 
			@RequestParam(required = false) Map<String, Object> queryString) {
		LOG.debug("get controller...");
		retryService.call(queryString);
	}
}
