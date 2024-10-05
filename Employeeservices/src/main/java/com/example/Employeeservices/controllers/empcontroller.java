package com.example.Employeeservices.controllers;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employeeservices.models.Employee;
import com.example.Employeeservices.services.empservice;

@RestController
public class empcontroller {
	
	@Autowired
	private empservice empservice;
	
	private static final Logger LOG = LoggerFactory.getLogger(empservice.class); 
	
	@GetMapping("/")
	public String greet() {
		
		LOG.info("Hello inside greet");
		return "Hello zypkine";
	}
	
	
	@PostMapping("/addemployee")
	public Employee addEmployee(Employee emp) {
		
		LOG.info("Inside Employee addition");
		
		return empservice.addemployee(emp);
		
	}
	
	
	
	

}
