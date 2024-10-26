package com.springboot.CustomSecurityWithDB.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import com.springboot.CustomSecurityWithDB.entities.Topic;

public interface TopicService {
	
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
	//@PreAuthorize("hasAnyRole('ADMIN','GUEST')")
	 public abstract List<Topic> getAllTopics();
	 
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
	 public abstract Topic getTopicById(int topicId);
	 
	 @Secured ({"ROLE_ADMIN"})
	 public abstract Topic addTopic(Topic topic);
	 
	 @Secured ({"ROLE_ADMIN"})
	 public abstract Topic updateTopic(Topic topic);
	 
	 @Secured ({"ROLE_ADMIN"})
	 public abstract void deleteTopic(int topicId);
}
