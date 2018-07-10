package com.example.demo.AboutJunitTest.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class JsonControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private JsonController jsonController;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(jsonController).build();
	}
	
	@Test
	public void json() throws Exception {
		
		mockMvc
			.perform(get("/json").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", Matchers.is("wkkim")))
			.andExpect(jsonPath("$.age", Matchers.is(28)))
			.andExpect(jsonPath("$.*", Matchers.hasSize(3)));		// check response json key size
	}
}
