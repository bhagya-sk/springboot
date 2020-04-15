package com.reactiveworks.practice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.reactiveworks.practice.model.Employee;
import com.reactiveworks.practice.repository.EmployeeRepository;

@Service
public class EmployeeService{
	
	@Autowired
	EmployeeRepository repository;

	public List<Employee> getEmployees(int pageNo, int pageSize,String sortBy){

		if(pageNo>0)
			pageNo-=1;
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Employee> pagedResult = repository.findAll(paging);
		if (pagedResult.hasContent()) {
		
			return pagedResult.getContent();
		} else {
			return new ArrayList<Employee>();
		}
	}

	public void addEmployee(Employee employee) {
		repository.save(employee);
	}

	public void addEmployees(List<Employee> employees) {
		repository.saveAll(employees);
	}

	public Employee getEmployeeById(int id) {
		return repository.findById(id).orElse(null);
	}

	public void updateEmployee(int id, Employee employee) {
		repository.save(employee);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}
}
