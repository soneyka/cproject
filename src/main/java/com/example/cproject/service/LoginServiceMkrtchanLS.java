package com.example.cproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.LoginMkrtchanLS;
import com.manipal.repository.LoginRepositoryMkrtchanLS;

@Service
public class LoginServiceMkrtchanLS {

	@Autowired
	private LoginRepositoryMkrtchanLS loginRepositoryMkrtchanLS;
		
	public void addLoginDetails(LoginMkrtchanLS loginMkrtchanLS) {
		loginRepositoryMkrtchanLS.save(loginMkrtchanLS);
	}
	
	public boolean loginValidation(LoginMkrtchanLS loginMkrtchanLS) {
		
		LoginMkrtchanLS loginMkrtchanLSInfo = loginRepositoryMkrtchanLS.findByUserName(loginMkrtchanLS.getUserName());
		String password = loginMkrtchanLSInfo.getPassword();
		if(password.equals(loginMkrtchanLS.getPassword()))
			return true;
		else
			return false;
	}
}
