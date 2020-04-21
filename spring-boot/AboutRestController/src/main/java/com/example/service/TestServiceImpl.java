package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestServiceImpl implements TestService
{

	@Override
	public void say()
	{
		log.info("********************************************************");
		log.info("************************************ Rest API Called !!!");
	}

	@Override
	public Map<String, Object> getMap()
	{
		Map<String, Object> map = new HashMap<>();
		
		map.put("one", 1);
		map.put("2", "two");
		map.put("name", "wkkim");
		
		return map;
	}
}
