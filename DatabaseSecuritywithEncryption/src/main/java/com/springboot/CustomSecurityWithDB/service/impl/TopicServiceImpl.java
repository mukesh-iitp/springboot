package com.springboot.CustomSecurityWithDB.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.CustomSecurityWithDB.Dao.TopicDAO;
import com.springboot.CustomSecurityWithDB.entities.Topic;
import com.springboot.CustomSecurityWithDB.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicDAO topicDAO;

	@Override
	public Topic getTopicById(int topicId) {
		Topic topic = topicDAO.findById(topicId).orElse(new Topic());
		return topic;
	}

	@Override
	public List<Topic> getAllTopics() {
		return topicDAO.findAll();
	}

	@Override
	public Topic addTopic(Topic topic) {
		return topicDAO.save(topic);
	}

	@Override
	public Topic updateTopic(Topic topic) {

		Topic topicDbObj = getTopicById(topic.getTopicId());
		if (topic.getTitle() != null) {
			topicDbObj.setTitle(topic.getTitle());
		}

		if (topic.getCategory() != null) {
			topicDbObj.setCategory(topic.getCategory());
		}
		return topicDAO.save(topicDbObj);
	}

	@Override
	public void deleteTopic(int topicId) {
		topicDAO.deleteById(topicId);
	}
}
