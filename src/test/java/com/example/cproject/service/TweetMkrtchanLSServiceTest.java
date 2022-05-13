package com.example.cproject.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.manipal.model.TweetMkrtchanLS;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.manipal.repository.TweetRepositoryMkrtchanLS;

@SpringBootTest
class TweetMkrtchanLSServiceTest {
	
	@Autowired 
	private TweetServiceMkrtchanLS tweetServiceMkrtchanLS;
	
	@MockBean
	private TweetRepositoryMkrtchanLS tweetRepositoryMkrtchanLS;

	@Test
	void testRetrieveAllTweets() {
		
		TweetMkrtchanLS tweetMkrtchanLS = new TweetMkrtchanLS(1,"Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		TweetMkrtchanLS tweetMkrtchanLS2 = new TweetMkrtchanLS(1,"Prateek", "Pjoshi", false, "#Holi", LocalDateTime.now(), "tweet image", "tweet Avatar",2);
		List<TweetMkrtchanLS> list = new ArrayList<TweetMkrtchanLS>();
		list.add(tweetMkrtchanLS);
		list.add(tweetMkrtchanLS2);

		when(tweetRepositoryMkrtchanLS.findAll()).thenReturn(list);
		assertEquals(2, tweetServiceMkrtchanLS.retrieveAllTweets().size());
	}

	@Test
	void testAddOrUpdateTweet() {
		TweetMkrtchanLS tweetMkrtchanLS = new TweetMkrtchanLS(1,"Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		tweetServiceMkrtchanLS.addOrUpdateTweet(tweetMkrtchanLS);
		verify(tweetRepositoryMkrtchanLS, times(1)).save(tweetMkrtchanLS);
	}

	@Test
	void testRetrieveTweetsByUserName() {
		TweetMkrtchanLS tweetMkrtchanLS = new TweetMkrtchanLS(1,"Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		TweetMkrtchanLS tweetMkrtchanLS2 = new TweetMkrtchanLS(2,"Param Attri", "Pattri", true, "#Holi", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		List<TweetMkrtchanLS> list = new ArrayList<TweetMkrtchanLS>();
		list.add(tweetMkrtchanLS);
		list.add(tweetMkrtchanLS2);
		
		when(tweetRepositoryMkrtchanLS.findByUserName("Pattri")).thenReturn(list);
		assertEquals(2, tweetServiceMkrtchanLS.retrieveTweetsByUserName("Pattri").size());
	}

	@Test
	void testDeleteTweetById() {
		TweetMkrtchanLS tweetMkrtchanLS = new TweetMkrtchanLS(1,"Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		tweetServiceMkrtchanLS.deleteTweetById(tweetMkrtchanLS.getTweetId());
		verify(tweetRepositoryMkrtchanLS, times(1)).deleteById(tweetMkrtchanLS.getTweetId());
	}

	@Test
	void testRetrieveTweetsByTweetId() {
		int tweetId = 10;
		TweetMkrtchanLS tweetMkrtchanLS = new TweetMkrtchanLS(10,"Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		when(tweetRepositoryMkrtchanLS.findById(tweetId)).thenReturn(Optional.of(tweetMkrtchanLS));
		assertEquals(tweetMkrtchanLS, tweetServiceMkrtchanLS.retrieveTweetsByTweetId(tweetId));
	}

}
