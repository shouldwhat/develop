package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@EnableRetry
public class TRetryController {

	private MockMvc mockMvc;
	
	@InjectMocks
	private RetryController retryController;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(retryController).build();
	}
	
	@Test
	public void retry() throws Exception {
		
		final String REQUEST_URI = "/get";
		
		mockMvc
			.perform(get(REQUEST_URI))
			.andExpect(status().isOk());
	}
}
