package com.example.Employeeservices.controllers;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employeeservices.models.Employee;

import com.example.Employeeservices.services.Empservice;



import java.io.Console;
import java.util.*;

@RestController
public class Empcontroller {
	
	@Autowired
	private Empservice empservice;
	
	private static final Logger LOG = LoggerFactory.getLogger(Empservice.class); 
	
	@GetMapping("/")
	public String greet() {
		
		LOG.info("Hello inside greet");
		return "Hello zypkine";
	}
	
	
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee emp) {
		
		LOG.info("Inside Employee addition");
		
		System.out.println(emp);
		
		return empservice.addemployee(emp);
		
	}
	
	
	@GetMapping("/getemployee")
	public List<Employee>  getallEmployee() {
		
		LOG.info("Inside Employee addition");
		
		return empservice.getallemployee();
		
	}
	
	@PutMapping("/updateemployee/{id}")
	public Employee updatEmployee(@PathVariable int id, @RequestBody Employee emp) {
	
		LOG.info("Inside the employee updation");

		Employee employee = empservice.updateemployee(id,emp);
		
		return employee;
		
	}
	
	@DeleteMapping("/deletemapping/{id}")
	public void deleteemployee(@PathVariable int id) {
		
		LOG.info("Hello delete employee");
		
		empservice.deleteservice(id);
		
	}
	
	
	
	

}
