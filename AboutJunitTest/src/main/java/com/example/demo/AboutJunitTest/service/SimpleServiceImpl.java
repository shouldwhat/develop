package com.example.demo.AboutJunitTest.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleServiceImpl implements SimpleService {

	@Override
	public String string() {
		return "This is simple string messages";
	}

}
