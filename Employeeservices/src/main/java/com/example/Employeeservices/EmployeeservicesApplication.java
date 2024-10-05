package com.example.Employeeservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeservicesApplication.class, args);
	}

}
