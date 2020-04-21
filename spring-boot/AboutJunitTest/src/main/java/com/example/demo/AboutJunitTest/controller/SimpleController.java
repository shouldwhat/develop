package com.example.demo.AboutJunitTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AboutJunitTest.service.SimpleService;

@RestController
@RequestMapping("/simple")
public class SimpleController {

	@Autowired
	private SimpleService simpleService;
	
	@GetMapping
	public String string() {
		return simpleService.string();
	}
}
