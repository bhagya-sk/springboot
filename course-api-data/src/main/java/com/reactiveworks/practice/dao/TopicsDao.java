package com.reactiveworks.practice.dao;

import org.springframework.data.repository.CrudRepository;

import com.reactiveworks.practice.model.Topic;

public interface TopicsDao extends CrudRepository<Topic, String> {

}
