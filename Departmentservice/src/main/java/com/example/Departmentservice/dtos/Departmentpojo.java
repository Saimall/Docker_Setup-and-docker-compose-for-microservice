package com.example.Departmentservice.dtos;

import java.util.List;

public class Departmentpojo {
	
private int id;
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", branch=" + branch + "]";
	}

	private String name;
	
	private String branch;
	
	private List<Employeepojo>employeepojos;
	
	public List<Employeepojo> getEmployeepojos() {
		return employeepojos;
	}

	public void setEmployeepojos(List<Employeepojo> employeepojos) {
		this.employeepojos = employeepojos;
	}

	public Departmentpojo() {
		
	}
	
	public Departmentpojo(int id, String name, String branch,List<Employeepojo>employeepojos) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.employeepojos = employeepojos;
	}


	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}



}
