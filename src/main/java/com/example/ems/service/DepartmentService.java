package com.example.ems.service;

import java.util.List;

import com.example.ems.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto createDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartment(Long id);
	
	List<DepartmentDto> getAllDepartment();
	
	DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto);
	
	String deleteDepartment(long id);
}
