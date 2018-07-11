package com.example.demo.AboutJunitTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AboutJunitTest.entity.User;
import com.example.demo.AboutJunitTest.service.JsonService;

@RestController("/json")
public class JsonController {

	@Autowired
	private JsonService jsonService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User user() {
		return jsonService.json();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User insertUser(@RequestBody User user) {
		return user;
	}
}
