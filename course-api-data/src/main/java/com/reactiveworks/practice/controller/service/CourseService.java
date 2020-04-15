package com.reactiveworks.practice.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactiveworks.practice.dao.CoursesDao;
import com.reactiveworks.practice.model.Course;

@Service
public class CourseService {

	@Autowired
	private CoursesDao courseDao;
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring", "spring framework", "spring framework description"),
//			new Topic("java", "java core", "core java description"),
//			new Topic("javaScript", "javaScript ", "javaScript description")
//
//	));

	public List<Course> getCourses(String topicId) {

		List<Course> courses = new ArrayList<>();
		courseDao.findByTopicId(topicId).forEach(courses::add);
		;
		return courses;
	}

	public Course getCourse(String id) {
		return courseDao.findOne(id);

	}

	public void addCourse(Course course) {
		courseDao.save(course);
	}

	public void deleteCourse(String id) {
		courseDao.delete(id);

	}

	public void updateCourse(String id, Course course) {

		courseDao.save(course);

	}
}