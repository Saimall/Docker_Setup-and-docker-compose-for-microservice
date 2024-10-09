package com.example.Departmentservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentserviceApplication {
	public static final Logger LOG=LoggerFactory.getLogger(DepartmentserviceApplication.class);

	public static void main(String[] args) {	
		LOG.info("Hello docker");;
		SpringApplication.run(DepartmentserviceApplication.class, args);
	}

}
