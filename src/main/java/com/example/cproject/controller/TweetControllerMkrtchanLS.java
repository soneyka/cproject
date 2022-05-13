package com.example.cproject.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.manipal.model.TweetMkrtchanLS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.service.TweetServiceMkrtchanLS;

@CrossOrigin(origins = "http://localhost:4000")
@RestController
public class TweetControllerMkrtchanLS {

	@Autowired
	private TweetServiceMkrtchanLS tweetServiceMkrtchanLS;
	
	@GetMapping("/twitter/tweets")
	public List<TweetMkrtchanLS> retriveAllTweets(){
		return tweetServiceMkrtchanLS.retrieveAllTweets();
	}
	
	@PostMapping("/twitter/tweet")
	public void addTweet(@RequestBody TweetMkrtchanLS tweetMkrtchanLS) {
		tweetMkrtchanLS.setTweetCreationTime(LocalDateTime.now());
		tweetServiceMkrtchanLS.addOrUpdateTweet(tweetMkrtchanLS);
	}
	
	@GetMapping("/twitter/tweets/user/{userName}")
	public List<TweetMkrtchanLS> retrieveTweetsByUserName(@PathVariable String userName){
		return tweetServiceMkrtchanLS.retrieveTweetsByUserName(userName);
	}
	
	@DeleteMapping("/twitter/tweets/{id}")
	public void deleteEmployee(@PathVariable int id){
		tweetServiceMkrtchanLS.deleteTweetById(id);
	}
	
	@GetMapping("/twitter/tweets/{id}")
	public TweetMkrtchanLS getTweetById(@PathVariable int id) {
		return tweetServiceMkrtchanLS.retrieveTweetsByTweetId(id);
	}
	
	@PutMapping("/twitter/tweets/{id}")
	public void updateTweet(@PathVariable int id, @RequestBody TweetMkrtchanLS tweetMkrtchanLSDetails){
		TweetMkrtchanLS tweetMkrtchanLS = tweetServiceMkrtchanLS.retrieveTweetsByTweetId(id);
		
		tweetMkrtchanLS.setTweetBody(tweetMkrtchanLSDetails.getTweetBody());
		tweetMkrtchanLS.setTweetImage(tweetMkrtchanLSDetails.getTweetImage());
		
		tweetServiceMkrtchanLS.addOrUpdateTweet(tweetMkrtchanLS);
	}
	
	@PutMapping("/twitter/tweets/like/{id}")
	public void updateTweetLikes(@PathVariable int id, @RequestBody TweetMkrtchanLS tweetMkrtchanLSDetails) {
		TweetMkrtchanLS tweetMkrtchanLS = tweetServiceMkrtchanLS.retrieveTweetsByTweetId(id);
		tweetMkrtchanLS.setLikes(tweetMkrtchanLSDetails.getLikes());
		tweetServiceMkrtchanLS.addOrUpdateTweet(tweetMkrtchanLS);
	}
}
