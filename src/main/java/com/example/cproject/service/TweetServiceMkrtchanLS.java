package com.example.cproject.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.manipal.model.TweetMkrtchanLS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.repository.TweetRepositoryMkrtchanLS;

@Service
public class TweetServiceMkrtchanLS {
	
	@Autowired
	private TweetRepositoryMkrtchanLS tweetRepositoryMkrtchanLS;

	public List<TweetMkrtchanLS> retrieveAllTweets(){
		
		List<TweetMkrtchanLS> tweetMkrtchanLS = tweetRepositoryMkrtchanLS.findAll();
		Collections.sort(tweetMkrtchanLS, (Comparator<? super TweetMkrtchanLS>) (t1, t2) -> {
			if(t1.getTweetCreationTime().isAfter(t2.getTweetCreationTime()))
				return -1;
			else
				return 1;
		});		
		return tweetMkrtchanLS;
	}
	
	public void addOrUpdateTweet(TweetMkrtchanLS tweetMkrtchanLS) {
		tweetRepositoryMkrtchanLS.save(tweetMkrtchanLS);
	}
	
	public List<TweetMkrtchanLS> retrieveTweetsByUserName(String userName) {
		
		List<TweetMkrtchanLS> tweetMkrtchanLS = tweetRepositoryMkrtchanLS.findByUserName(userName);
		Collections.sort(tweetMkrtchanLS, (Comparator<? super TweetMkrtchanLS>) (t1, t2) -> {
			if(t1.getTweetCreationTime().isAfter(t2.getTweetCreationTime()))
				return -1;
			else
				return 1;
		});
		
		return tweetMkrtchanLS;
	}
	
	public void deleteTweetById(int tweetId) {
		tweetRepositoryMkrtchanLS.deleteById(tweetId);
	}
	
	public TweetMkrtchanLS retrieveTweetsByTweetId(int tweetId) {
		return tweetRepositoryMkrtchanLS.findById(tweetId).orElse(null);
	}
}
