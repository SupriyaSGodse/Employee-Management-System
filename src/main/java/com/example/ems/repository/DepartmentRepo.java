package com.example.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
