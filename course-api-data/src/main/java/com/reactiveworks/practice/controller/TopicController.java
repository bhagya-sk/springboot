package com.reactiveworks.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reactiveworks.practice.controller.service.TopicService;
import com.reactiveworks.practice.model.Topic;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> sayHello() {
		
		return topicService.getTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
	public void addProduct(@PathVariable String id,@RequestBody Topic topic) {
		topicService.updateTopic(id,topic);
	}

}
