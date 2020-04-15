package com.reactiveworks.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reactiveworks.practice.model.Employee;
import com.reactiveworks.practice.response.ResponseTransfer;
import com.reactiveworks.practice.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/hello")
	public ResponseEntity<String> sayHello(){
		HttpHeaders header=new HttpHeaders();
		header.add("custom header", "hello");
		return new ResponseEntity<>("custom header set",header,HttpStatus.OK);
	}
	
	@GetMapping(value = "/test", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseTransfer postResponseXmlContent() {
	    return new ResponseTransfer("XML Content!");
	}
	
	@GetMapping(value  = "/test",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseTransfer getResponse() {
		return new ResponseTransfer("json content");
	}
	
	

	@RequestMapping
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping
	public void addEmployees(@RequestBody List<Employee> employees) {
		employeeService.addEmployees(employees);

	}

	@PutMapping("/{id}")
	public void updateEmployeeDetails(@PathVariable int id, @RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.delete(id);
	}

}
