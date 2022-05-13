package com.example.cproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manipal.model.LoginMkrtchanLS;

public interface LoginRepositoryMkrtchanLS extends JpaRepository<LoginMkrtchanLS, String>{
	
	LoginMkrtchanLS findByUserName(String userName);
}
