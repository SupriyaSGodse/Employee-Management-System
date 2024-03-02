package com.example.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
