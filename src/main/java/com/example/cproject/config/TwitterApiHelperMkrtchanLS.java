package com.example.cproject.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.twitter.api.Twitter;

public class TwitterApiHelper implements ApiHelper<Twitter> {
	
	private final UsersConnectionRepository usersConnectionRepository;

	private final UserIdSource userIdSource;

	private TwitterApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
		this.usersConnectionRepository = usersConnectionRepository;
		this.userIdSource = userIdSource;		
	}

	public Twitter getApi() {
		if (logger.isDebugEnabled()) {
			logger.debug("Getting API binding instance for Twitter");
		}
				
		Connection<Twitter> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(Twitter.class);
		if (logger.isDebugEnabled() && connection == null) {
			logger.debug("No current connection; Returning default TwitterTemplate instance.");
		}
		return connection != null ? connection.getApi() : null;
	}
	
	private final static Log logger = LogFactory.getLog(TwitterApiHelper.class);

}