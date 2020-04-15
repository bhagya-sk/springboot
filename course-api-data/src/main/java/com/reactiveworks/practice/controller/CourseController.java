package com.reactiveworks.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reactiveworks.practice.controller.service.CourseService;
import com.reactiveworks.practice.model.Course;
import com.reactiveworks.practice.model.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getCourses(@PathVariable("id") String id) {
		
		return courseService.getCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getTopic(@PathVariable("id") String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@PathVariable String id,@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(id,course);
	}

}
