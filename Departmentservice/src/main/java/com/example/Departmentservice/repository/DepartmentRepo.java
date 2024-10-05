package com.example.Departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Departmentservice.models.Department;

@Repository
public interface DepartmentRepo extends JpaRepository <Department,Integer> {

}
