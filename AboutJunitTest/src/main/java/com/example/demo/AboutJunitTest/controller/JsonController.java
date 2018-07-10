package com.example.demo.AboutJunitTest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AboutJunitTest.entity.User;

@RestController("/json")
public class JsonController {

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User user() {
		return new User("wkkim", 28);
	}
}
