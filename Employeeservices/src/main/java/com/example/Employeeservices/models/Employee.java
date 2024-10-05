package com.example.Employeeservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	private String empname;
	
	public Employee() {
		
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + "]";
	}

	
	
	public Employee(int id, String empname) {
		super();
		this.id = id;
		this.empname = empname;
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}


}
