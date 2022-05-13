package com.example.cproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.LoginMkrtchanLS;
import com.manipal.model.UserMkrtchanLS;
import com.manipal.service.LoginServiceMkrtchanLS;
import com.manipal.service.UserServiceMkrtchanLS;

@CrossOrigin(origins = "http://localhost:4000")
@RestController
public class UserControllerMkrtchanLS {
	
	@Autowired
	private UserServiceMkrtchanLS userServiceMkrtchanLS;
	
	@Autowired
	private LoginServiceMkrtchanLS loginServiceMkrtchanLS;
	
	@PostMapping("/twitter/register")
	public String registration(@RequestBody UserMkrtchanLS userMkrtchanLS) {
		
		String registrationResponse = userServiceMkrtchanLS.registation(userMkrtchanLS);
		if(registrationResponse.equals("Success")) {
			LoginMkrtchanLS loginMkrtchanLS = new LoginMkrtchanLS();
			loginMkrtchanLS.setUserName(userMkrtchanLS.getUserName());
			loginMkrtchanLS.setPassword(userMkrtchanLS.getPassword());
			loginServiceMkrtchanLS.addLoginDetails(loginMkrtchanLS);
			return registrationResponse;
		}
		
		return registrationResponse;
	}
	
	@GetMapping("/twitter/user/{userName}")
	public UserMkrtchanLS userDetails(@PathVariable String userName){
		return userServiceMkrtchanLS.userDetails(userName);
	}

}
