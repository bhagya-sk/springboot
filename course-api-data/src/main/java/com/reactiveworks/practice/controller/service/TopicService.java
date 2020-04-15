package com.reactiveworks.practice.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactiveworks.practice.dao.TopicsDao;
import com.reactiveworks.practice.model.Topic;

@Service
public class TopicService {

	@Autowired
	private TopicsDao topicsDao;
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring", "spring framework", "spring framework description"),
//			new Topic("java", "java core", "core java description"),
//			new Topic("javaScript", "javaScript ", "javaScript description")
//
//	));

	public List<Topic> getTopics() {

		List<Topic> topics = new ArrayList<>();
		topicsDao.findAll().forEach(topics::add);
		;
		return topics;
	}

	public Topic getTopic(String id) {
		return topicsDao.findOne(id);

	}

	public void addTopic(Topic topic) {
		topicsDao.save(topic);
	}

	public void deleteTopic(String id) {
		topicsDao.delete(id);

	}

	public void updateTopic(String id, Topic topic) {

		topicsDao.save(topic);

	}
}