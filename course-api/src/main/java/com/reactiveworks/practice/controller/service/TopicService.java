package com.reactiveworks.practice.controller.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.reactiveworks.practice.model.Topic;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring", "spring framework", "spring framework description"),
			new Topic("java", "java core", "core java description"),
			new Topic("javaScript", "javaScript ", "javaScript description")

	));

	public List<Topic> getTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		Topic topic = topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

		return topic;
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
		
	}

	public void updateTopic(String id, Topic topic) {
		
		for(int i=0;i<topics.size();i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
		
	}
}
