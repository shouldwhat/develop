package com.example.demo.AboutJunitTest.service;

import org.springframework.stereotype.Service;

import com.example.demo.AboutJunitTest.entity.User;

@Service
public class JsonServiceImpl implements JsonService {

	@Override
	public User json() {
		return new User("wkkim", 28);
	}
}
