package com.example.cproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.LoginMkrtchanLS;
import com.manipal.service.LoginServiceMkrtchanLS;

@CrossOrigin(origins = "http://localhost:4000")
@RestController
public class LoginControllerMkrtchanLS {
	
	@Autowired
	private LoginServiceMkrtchanLS loginServiceMkrtchanLS;
	
	@PostMapping("/twitter/login")
	public String login(@RequestBody LoginMkrtchanLS loginMkrtchanLS) {
	
		boolean isValidated = loginServiceMkrtchanLS.loginValidation(loginMkrtchanLS);
		if(isValidated) {
			return "Success";
		}
		else
			return "Not Success";
	}

}
