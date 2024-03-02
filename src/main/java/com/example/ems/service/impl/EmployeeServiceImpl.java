package com.example.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.entity.Employee;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.mapper.EmployeeMapper;
import com.example.ems.repository.EmployeeRepo;
import com.example.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
		
		Employee savedEmployee=employeeRepo.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployee(long id) {
		 Employee employee= employeeRepo.findById(id)
		 .orElseThrow(()-> new ResourceNotFoundException("Employee is not exists with given id : "+id));
		
		 return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees=employeeRepo.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(long id, EmployeeDto employeeDto) {
		
		Employee employee = employeeRepo.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Employee is not exists with given id :" + id));
		
		
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		
		Employee updatedEmployee= employeeRepo.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	}

	@Override
	public void deleteEmployee(long id) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee is not exists with given id :" + id));
				
		employeeRepo.deleteById(id);
	}

}
