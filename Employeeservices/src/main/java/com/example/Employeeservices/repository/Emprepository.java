package com.example.Employeeservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employeeservices.models.Employee;

@Repository
public interface Emprepository extends JpaRepository<Employee,Integer>{

}