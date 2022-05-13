package com.example.cproject.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.UserMkrtchanLS;
import com.manipal.repository.UserRepositoryMkrtchanLS;


@Service
public class UserServiceMkrtchanLS {
	
	@Autowired
	private UserRepositoryMkrtchanLS userRepositoryMkrtchanLS;
	
	public String registation(UserMkrtchanLS userMkrtchanLS) {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<UserMkrtchanLS>> violations = validator.validate(userMkrtchanLS);
		String errorMessage = "";
		for (ConstraintViolation<UserMkrtchanLS> violation : violations) {
		    errorMessage = violation.getMessage();
		}
		
		if(errorMessage.equals("")) {
			userRepositoryMkrtchanLS.save(userMkrtchanLS);
			return "Success";
		}
		else {
			return errorMessage;
		}
	}

	public UserMkrtchanLS userDetails(String userName) {
		return userRepositoryMkrtchanLS.findByUserName(userName);
	}
}