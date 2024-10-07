package com.example.Employeeservices.dtos;




public class Employeepojo {
	
private int id;
	
	
	private int departmentId;
	private String empname;
	
	
	
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	

	public Employeepojo() {
		
	}

	public Employeepojo(int id, String empname,int departmentId) {
		
		this.id = id;
		this.empname = empname;
		this.departmentId=departmentId;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + "]";
	}
	
	

}
