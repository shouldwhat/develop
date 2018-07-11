package com.example.demo.AboutJunitTest.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.AboutJunitTest.controller.SimpleController;

@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleServiceTest {

	private MockMvc mockMvc;
	
	@Mock
	private SimpleService simpleService;
	
	@InjectMocks
	private SimpleController simpleController;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(simpleController).build();
	}
	
	@Test
	public void json() throws Exception {
		
		Mockito.when(simpleService.string()).thenReturn("hello world");
		
		mockMvc
			.perform(MockMvcRequestBuilders.get("/simple"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("hello world"));
		
		Mockito.verify(simpleService).string();
	}
}
