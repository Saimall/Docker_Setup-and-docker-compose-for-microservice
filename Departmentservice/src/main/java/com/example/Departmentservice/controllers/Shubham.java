package com.example.Departmentservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Departmentservice.models.Department;
import com.example.Departmentservice.service.Departmentservice;

@RestController
public class Shubham {
	
	@Autowired
	private Departmentservice departmentservice;
	
public static final Logger LOG = LoggerFactory.getLogger(Shubham.class);
	
	@GetMapping("/")
	public String greet() {
		
		LOG.info("Hello inside greet");
		return "Hello zypkine";
	}
	
	
	@PostMapping("/adddepartment")
	public Department adddepartment(@RequestBody Department department) {
		LOG.info("Inside add department ");
		return departmentservice.adddepartment(department);
	}
	
	@DeleteMapping("/deletedepartment/{id}")
	public void deleteepartment(@PathVariable int id) {
	LOG.info("Inside Delete function");
		departmentservice.deletedepartment(id);
	}
	
	
	@PutMapping("/updatedepartment/{id}")
	public Department updatedepartment(@PathVariable int id, @RequestBody Department department) {
		
		Department depart= departmentservice.updatedepartment(id,department);
		
		return depart;
		
		
	
		
	}
	
	@GetMapping("/getdepartments")
	public List<Department> getdepartments(){
		List<Department> alldepartments = departmentservice.getalldepartments();
		
		return alldepartments;
		
	}

}
