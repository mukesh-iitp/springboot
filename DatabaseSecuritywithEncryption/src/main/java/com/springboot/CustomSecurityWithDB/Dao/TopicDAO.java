package com.springboot.CustomSecurityWithDB.Dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.CustomSecurityWithDB.entities.Topic;


@Repository
public interface TopicDAO extends JpaRepository<Topic, Integer> {
	/*public abstract List<Topic> getAllTopics();
	public abstract Topic getTopicById(int topicId);
	public abstract void addTopic(Topic topic);
	public abstract void updateTopic(Topic topic);
	public abstract void deleteTopic(int topicId);
	public abstract boolean topicExists(String title, String category);*/
}