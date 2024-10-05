package com.example.Departmentservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Shubham {
	
public static final Logger LOG = LoggerFactory.getLogger(Shubham.class);
	
	@GetMapping("/")
	public String greet() {
		
		LOG.info("Hello inside greet");
		return "Hello zypkine";
	}

}
