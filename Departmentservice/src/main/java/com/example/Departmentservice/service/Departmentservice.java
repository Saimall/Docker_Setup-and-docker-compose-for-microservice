package com.example.Departmentservice.service;

import java.beans.Beans;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.Departmentservice.dtos.Departmentpojo;
import com.example.Departmentservice.dtos.Employeepojo;
import com.example.Departmentservice.models.Department;
import com.example.Departmentservice.repository.DepartmentRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service

public class Departmentservice {

	@Autowired
	private DepartmentRepo departmentrepo;
	
	
	public Department adddepartment(Department department) {
	
	Department depart=	departmentrepo.save(department);
	
	return depart;
		
		
	}


	public void deletedepartment(int id) {
	
		departmentrepo.deleteById(id);
	}


	public Department updatedepartment(int id, Department department) {
		
		Optional<Department> depart = departmentrepo.findById(id);
		
		depart.get().setBranch(department.getBranch());
		depart.get().setName(department.getName());
		
		departmentrepo.save(depart.get());
		
		return depart.get();
		
	}


	public List<Department> getalldepartments() {
		
		List<Department> departments = departmentrepo.findAll();
		return departments;
	}


	@CircuitBreaker(name="ciremp", fallbackMethod = "fallbackEmployee")
	public Departmentpojo finddepartmentbyid(int id) {
		
		Optional<Department> departmentOptional = departmentrepo.findById(id);

		Departmentpojo departmentpojo = new Departmentpojo();
		BeanUtils.copyProperties(departmentOptional.get(), departmentpojo);
		
		RestClient restClient = RestClient.create();
		
	List<Employeepojo>allemployeesEmployeepojos=restClient.get().uri("http://localhost:8080/employee//Getallemployeesbydepartment/"+ id).retrieve().body(List.class);
		departmentpojo.setEmployeepojos(allemployeesEmployeepojos);
		
		return departmentpojo;
		
		
	}
	
	public Departmentpojo fallbackEmployee() {
		return new Departmentpojo(0,"fallback",null, null);
		
	}
	
	

}
