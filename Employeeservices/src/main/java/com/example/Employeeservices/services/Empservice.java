package com.example.Employeeservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.Employeeservices.models.Employee;
import com.example.Employeeservices.repository.Emprepository;



@Service
public class Empservice {

	
	@Autowired
	private Emprepository emprepository;
	
	
	
	
	public Employee addemployee(Employee emp) {
		
		 
		return  emprepository.saveAndFlush(emp) ;
		
	}



	public List<Employee> getallemployee() {
		
		List<Employee> allemp = emprepository.findAll();
		// TODO Auto-generated method stub
		return allemp;
	}



	public Employee updateemployee(int id, Employee emp) {
		
		Optional<Employee> employee = emprepository.findById(id);
		
		employee.get().setEmpname(emp.getEmpname());
		
		emprepository.save(employee.get());
		
		return employee.get();
		
		
	}



	public void deleteservice(int id) {
		
		emprepository.deleteById(id);
		
		// TODO Auto-generated method stub
		
	}
	
	

}
