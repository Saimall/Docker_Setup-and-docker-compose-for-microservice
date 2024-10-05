package com.example.Employeeservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.Employeeservices.models.Employee;
import com.example.Employeeservices.repository.emprepository;

@Service
public class empservice {

	
	@Autowired
	private emprepository emprepository;
	
	public Employee addemployee(Employee emp) {
		
		return emprepository.save(emp) ;
	}

}
