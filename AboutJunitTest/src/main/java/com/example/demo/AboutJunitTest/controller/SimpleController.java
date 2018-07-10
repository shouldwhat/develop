package com.example.demo.AboutJunitTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleController {

	@GetMapping
	public String string() {
		return "This is simple string messages";
	}
}
