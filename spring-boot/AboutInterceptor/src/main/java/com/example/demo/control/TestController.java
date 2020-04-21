package com.example.demo.control;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping(value = "/")
	public void test(HttpServletRequest request) {
		LOG.debug("hello world [{}]", request.getRequestURI());
	}
}
