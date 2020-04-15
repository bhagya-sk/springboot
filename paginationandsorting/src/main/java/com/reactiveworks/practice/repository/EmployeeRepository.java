package com.reactiveworks.practice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.reactiveworks.practice.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

}