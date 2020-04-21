package com.example.demo.AboutJunitTest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private SimpleController simpleController;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(simpleController).build();
	}
	
	@Test
	public void string() throws Exception {
		
		mockMvc
			.perform(MockMvcRequestBuilders.get("/simple"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("this is simple string messages"));
	}
}
