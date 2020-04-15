package com.reactiveworks.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reactiveworks.practice.model.Employee;
import com.reactiveworks.practice.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees")
	public List<Employee> getEmployees(@RequestParam(defaultValue = "0") int pageNo, 
                                       @RequestParam(defaultValue = "10") int pageSize) {
		return employeeService.getEmployees(pageNo,pageSize);
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}

//	@PostMapping("/employees")
//	public void addEmployee(@RequestBody Employee employee) {
//		employeeService.addEmployee(employee);
//	}

	@PostMapping("/employees")
	public void addEmployees(@RequestBody List<Employee> employees) {
		employeeService.addEmployees(employees);

	}

	@PutMapping("/employees/{id}")
	public void updateEmployeeDetails(@PathVariable int id, @RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.delete(id);
	}

}
