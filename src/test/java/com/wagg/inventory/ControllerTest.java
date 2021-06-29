package com.wagg.inventory;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	
	@Autowired(required = true)
	private MockMvc mvc;
	
	@Test
	public void getAllUsers_thenStatus200() throws Exception {
		mvc.perform(get("/users/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is(HttpStatus.OK.value()))
			.andExpect(jsonPath("$[0].name",is("Gabriel")));
	}
	
	@Test
	public void getAllProducts_thenStatus200() throws Exception {
		mvc.perform(get("/users/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is(HttpStatus.OK.value()))
			.andExpect(jsonPath("$[0].id",is(1)));
	}
	
}
