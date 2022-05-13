package com.example.cproject.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import com.manipal.model.TweetMkrtchanLS;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manipal.service.TweetServiceMkrtchanLS;

@WebMvcTest(TweetControllerMkrtchanLS.class)
class TweetMkrtchanLSControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TweetServiceMkrtchanLS tweetServiceMkrtchanLS;
	
	@Test
	void testRetriveAllTweets() throws Exception {
		mvc.perform(get("/twitter/tweetMkrtchanLS").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testAddTweet() throws JsonProcessingException, Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		TweetMkrtchanLS tweetMkrtchanLS = new TweetMkrtchanLS(1, "Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet avatar", 1);
		
		mvc.perform(post("/twitter/tweet")
				.content(objectMapper.writeValueAsString(tweetMkrtchanLS))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(400));
		
		verify(tweetServiceMkrtchanLS, times(0)).addOrUpdateTweet(tweetMkrtchanLS);
	}

	@Test
	void testRetrieveTweetsByUserName() throws Exception {
		mvc.perform(get("/twitter/tweetMkrtchanLS/user/Pattri").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testDeleteEmployee() throws Exception {
		mvc.perform(delete("/twitter/tweetMkrtchanLS/10").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testGetTweetById() throws Exception {
		mvc.perform(get("/twitter/tweetMkrtchanLS/2").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testUpdateTweet() throws JsonProcessingException, Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		TweetMkrtchanLS tweetMkrtchanLS = new TweetMkrtchanLS(1, "Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet avatar", 1);
		
		mvc.perform(put("/twitter/tweetMkrtchanLS/2")
				.content(objectMapper.writeValueAsString(tweetMkrtchanLS))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(400));
		
	}

}
