package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.properties.TestProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestListener implements ApplicationListener<ContextRefreshedEvent>
{

	@Autowired
	TestProperties testProperties;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0)
	{
		log.info("*************************** testProperties.one = {}", testProperties.getOne());
		log.info("*************************** testProperties.two = {}", testProperties.getTwo());
	}
}
