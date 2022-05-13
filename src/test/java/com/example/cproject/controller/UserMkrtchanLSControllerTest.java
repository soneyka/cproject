package com.example.cproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.manipal.service.LoginServiceMkrtchanLS;
import com.manipal.service.UserServiceMkrtchanLS;

@WebMvcTest(UserControllerMkrtchanLS.class)
class UserMkrtchanLSControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserServiceMkrtchanLS userServiceMkrtchanLS;
	
	@MockBean
	private LoginServiceMkrtchanLS loginServiceMkrtchanLS;
	
	@Test
	void testUserDetails() throws Exception {	
		mvc.perform(get("/twitter/user/Pattri").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
