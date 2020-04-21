package com.example.demo.AboutJunitTest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.AboutJunitTest.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
public class JsonServiceTest {

	@Mock
	private JsonService jsonService;
	
	@Test
	public void json() {
		Mockito.when(jsonService.json()).thenReturn(new User("wkkim", 28));
	}
}
