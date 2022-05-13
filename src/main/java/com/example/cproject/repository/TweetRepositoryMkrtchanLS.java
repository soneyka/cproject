package com.example.cproject.repository;

import java.util.List;

import com.manipal.model.TweetMkrtchanLS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepositoryMkrtchanLS extends JpaRepository<TweetMkrtchanLS, Integer>{
	
	List<TweetMkrtchanLS> findByUserName(String userName);
}
