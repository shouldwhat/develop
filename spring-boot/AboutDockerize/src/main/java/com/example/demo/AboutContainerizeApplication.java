package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AboutContainerizeApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello Docker world";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AboutContainerizeApplication.class, args);
	}
}
