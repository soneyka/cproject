package com.example.cproject.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.manipal.model.UserMkrtchanLS;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.manipal.repository.UserRepositoryMkrtchanLS;

@SpringBootTest
class UserMkrtchanLSServiceTest {
	
	@Autowired
	private UserServiceMkrtchanLS userServiceMkrtchanLS;
	
	@MockBean
	private UserRepositoryMkrtchanLS userRepositoryMkrtchanLS;
	
	@Test
	void testRegistation() {
		UserMkrtchanLS userMkrtchanLS = new UserMkrtchanLS("Param Attri","Pattri","attri@gmail.com","qwerty","param avatar");
		userServiceMkrtchanLS.registation(userMkrtchanLS);
		verify(userRepositoryMkrtchanLS, times(1)).save(userMkrtchanLS);
	}

	@Test
	void testUserDetails() {
		userServiceMkrtchanLS.userDetails("Param");
		verify(userRepositoryMkrtchanLS, times(1)).findByUserName("Param");
	}

}
