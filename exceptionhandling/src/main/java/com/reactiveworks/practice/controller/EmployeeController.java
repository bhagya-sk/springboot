package com.reactiveworks.practice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactiveworks.practice.exception.EmployeeNotFoundException;
import com.reactiveworks.practice.model.Employee;
import com.reactiveworks.practice.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() throws EmployeeNotFoundException {
		List<Employee> employees = employeeService.getEmployees();
		if (employees.size()==0) {
			System.out.println("exception occured");
			throw new EmployeeNotFoundException("employees details not available");
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		Employee employee = employeeService.getEmployeeById(id);
		System.out.println(employee);
		if (employee == null) {
			
			throw new EmployeeNotFoundException("employee with id " + id + " is not found");
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}

//	@PostMapping("/employees")
//	public ResponseEntity<List<Employee>> addEmployees(@Valid @RequestBody List<Employee> employees) {
//		employeeService.addEmployees(employees);
//		return new ResponseEntity<List<Employee>>(employees, HttpStatus.CREATED);
//	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

}
