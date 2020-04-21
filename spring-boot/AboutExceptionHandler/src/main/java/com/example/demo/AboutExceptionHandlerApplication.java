package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class AboutExceptionHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AboutExceptionHandlerApplication.class, args);
	}
}
