package com.example.springsecuirtydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringsecuirtydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuirtydemoApplication.class, args);
	}

}
