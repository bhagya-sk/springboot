package com.reactiveworks.practice.model;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@XmlRootElement
public class Employee {
	@NotEmpty(message = "first name must not be empty")
	private String name;
	@Id
	private int empNo;
	private double salary;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;
	@Embedded
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", empNo=" + empNo + ", salary=" + salary + ", joiningDate=" + joiningDate
				+ ", address=" + address + "]";
	}

}
