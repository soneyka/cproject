package com.example.cproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manipal.model.UserMkrtchanLS;

public interface UserRepositoryMkrtchanLS extends JpaRepository<UserMkrtchanLS, String>{
	UserMkrtchanLS findByUserName(String userName);
}
