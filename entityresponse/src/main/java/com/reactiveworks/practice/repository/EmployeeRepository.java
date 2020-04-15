package com.reactiveworks.practice.repository;

import org.springframework.data.repository.CrudRepository;

import com.reactiveworks.practice.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}