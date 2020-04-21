package com.example.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/test")
public class TestController
{
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/say", method = RequestMethod.GET/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
	public void say(HttpServletRequest request)
	{
		testService.say();
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> json(HttpServletRequest request)
	{
		return testService.getMap();
	}
}
