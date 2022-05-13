package com.example.cproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manipal.model.LoginMkrtchanLS;
import com.manipal.service.LoginServiceMkrtchanLS;

@WebMvcTest(LoginControllerMkrtchanLS.class)
class LoginControllerMkrtchanLSTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private LoginServiceMkrtchanLS loginServiceMkrtchanLS;
	
	@Test
	void testLogin() throws JsonProcessingException, Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		LoginMkrtchanLS loginMkrtchanLS = new LoginMkrtchanLS("Pattri","qwerty");
		
		mvc.perform(post("/twitter/login")
				.content(objectMapper.writeValueAsString(loginMkrtchanLS))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
