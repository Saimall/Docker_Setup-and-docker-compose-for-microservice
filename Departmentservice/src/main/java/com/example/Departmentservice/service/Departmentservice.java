package com.example.Departmentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Departmentservice.models.Department;
import com.example.Departmentservice.repository.DepartmentRepo;

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
	
	

}
