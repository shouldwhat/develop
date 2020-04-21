package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.yaml.TYamlFormat;

@SpringBootApplication
public class YamlApplication {

	public static void main(String[] args) {
		SpringApplication.run(YamlApplication.class, args);
		new TYamlFormat().test();
	}
}
