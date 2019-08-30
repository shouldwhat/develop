package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MyRequest;
import com.example.demo.searchOption.MySearchOption;

@RestController
public class TestController {

	private Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	@PostMapping("/post")
	public void post(HttpServletRequest request, 
			@RequestBody MyRequest entity) {
		LOG.debug("entity = {}", entity.toMap());
	}
	
	@GetMapping("/get")
	public void get(HttpServletRequest request, 
			MySearchOption searchOption) {
		LOG.debug("searchOption = {}", searchOption);
	}
}
