package com.reactiveworks.practice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.reactiveworks.practice.model.Course;

public interface CoursesDao extends CrudRepository<Course, String> {

	public List<Course> findByTopicId(String topicId); //jpa provides implementation for this
}
