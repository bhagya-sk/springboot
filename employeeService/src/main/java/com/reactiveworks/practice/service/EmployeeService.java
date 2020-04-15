package com.reactiveworks.practice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactiveworks.practice.model.Employee;
import com.reactiveworks.practice.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;

	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		repository.findAll().forEach(employees::add);
		return employees;
	}

	public void addEmployee(Employee employee) {
		repository.save(employee);
	}

	public void addEmployees(List<Employee> employees) {
		repository.saveAll(employees);
	}

	public Employee getEmployeeById(int id) {
		return repository.findById(id).get();
	}
	
	public void updateEmployee(int id,Employee employee) {
		repository.save(employee);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
}
