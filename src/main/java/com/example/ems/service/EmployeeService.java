package com.example.ems.service;

import java.util.List;

import com.example.ems.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployee(long id);
	
	List<EmployeeDto> getAllEmployee();
	
	EmployeeDto updateEmployee(long id, EmployeeDto employeeDto);
	
	void deleteEmployee(long id);
}
