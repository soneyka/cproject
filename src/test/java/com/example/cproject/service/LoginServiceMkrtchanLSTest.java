package com.example.cproject.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.manipal.model.LoginMkrtchanLS;
import com.manipal.repository.LoginRepositoryMkrtchanLS;

@SpringBootTest
class LoginServiceMkrtchanLSTest {
	
	@Autowired
	private LoginServiceMkrtchanLS loginServiceMkrtchanLS;
	
	@MockBean
	private LoginRepositoryMkrtchanLS loginRepositoryMkrtchanLS;
	
	@Test
	void testAddLoginDetails() {
		LoginMkrtchanLS loginMkrtchanLS = new LoginMkrtchanLS("Pattri","qwerty");
		loginServiceMkrtchanLS.addLoginDetails(loginMkrtchanLS);
		verify(loginRepositoryMkrtchanLS, times(1)).save(loginMkrtchanLS);
	}

	@Test
	void testLoginValidation() {
		LoginMkrtchanLS loginMkrtchanLS = new LoginMkrtchanLS("Pattri","qwerty");
		when(loginRepositoryMkrtchanLS.findByUserName(loginMkrtchanLS.getUserName())).thenReturn(loginMkrtchanLS);
		loginServiceMkrtchanLS.loginValidation(loginMkrtchanLS);
		verify(loginRepositoryMkrtchanLS, times(1)).findByUserName(loginMkrtchanLS.getUserName());
	}

}
