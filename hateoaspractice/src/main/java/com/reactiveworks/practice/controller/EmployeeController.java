package com.reactiveworks.practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping
	public CollectionModel<Employee> getEmployees(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "empNo") String sortBy) {
		List<Employee> employees = employeeService.getEmployees(pageNo, pageSize, sortBy);

		for (Employee employee : employees) {
			List<Link> links=new ArrayList<Link>();
			Link link = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getEmployee(employee.getEmpNo()))
					.withSelfRel();
			links.add(link);
			link = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).deleteEmployee(employee.getEmpNo()))
					.withRel("delete");
			links.add(link);
			link = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).updateEmployeeDetails(employee.getEmpNo(),employee))
					.withRel("update");
			links.add(link);
			employee.add(links);

		}
		Link link = WebMvcLinkBuilder.linkTo(EmployeeController.class).withRel("employees");
		CollectionModel<Employee> result = new CollectionModel<>(employees, link);

		return result;
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee employee=employeeService.getEmployeeById(id);
		List<Link> links=new ArrayList<Link>();
		Link link = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getEmployee(employee.getEmpNo()))
				.withSelfRel();
		links.add(link);
		link = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).deleteEmployee(employee.getEmpNo()))
				.withRel("delete");
		links.add(link);
		employee.add(links);
		return employee;
	}

	@PostMapping
	public ResponseEntity<?> addEmployees(@RequestBody List<Employee> employees) {
		employeeService.addEmployees(employees);
		ResponseEntity<Employee> response=new ResponseEntity<Employee>( HttpStatus.CREATED);
		return response;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployeeDetails(@PathVariable int id, @RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
		return new ResponseEntity<Employee>( HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		employeeService.delete(id);
		return new ResponseEntity<Employee>( HttpStatus.OK);
	}

//	private Link getSingleItemLinks(int id) {
//		return WebMvcLinkBuilder.linkTo(EmployeeController.class).withSelfRel()
//				.andAffordance(WebMvcLinkBuilder
//						.afford(WebMvcLinkBuilder.methodOn(EmployeeController.class).updateEmployeeDetails(id, null)))
//				.andAffordance(WebMvcLinkBuilder
//						.afford(WebMvcLinkBuilder.methodOn(EmployeeController.class).deleteEmployee(id)));
//
//	}

}
