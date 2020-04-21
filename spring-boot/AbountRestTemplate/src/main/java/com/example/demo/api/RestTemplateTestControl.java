package com.example.demo.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateTestControl {

	private static final Logger LOG = LoggerFactory.getLogger(RestTemplateTestControl.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public void index(HttpServletRequest request) {
		LOG.debug("call get api");
		Object forObject = restTemplate.getForObject("/", Object.class);
	}
}
