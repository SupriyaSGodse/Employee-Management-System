package com.example.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ems.dto.DepartmentDto;
import com.example.ems.entity.Department;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.mapper.DepartmentMapper;
import com.example.ems.repository.DepartmentRepo;
import com.example.ems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepo departmentRepo;
	
	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		 
		Department department= DepartmentMapper.mapToDepartment(departmentDto);
		Department savedDepartment=departmentRepo.save(department);	
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}

	@Override
	public DepartmentDto getDepartment(Long id) {
		Department department = departmentRepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Department is not present for this id"+id));
		return DepartmentMapper.mapToDepartmentDto(department);
	}

	@Override
	public List<DepartmentDto> getAllDepartment() {

		List<Department> departments = departmentRepo.findAll();
		return departments.stream()
				.map((department)->DepartmentMapper.mapToDepartmentDto(department))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
		Department department = departmentRepo.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Department is not present for this id" +id));
		
		department.setDepartmentName(departmentDto.getDepartmentName());
		department.setDepartmentDescription(departmentDto.getDepartmentDescription());
		
		Department updatedDepartment= departmentRepo.save(department);
		return DepartmentMapper.mapToDepartmentDto(updatedDepartment);
	}

	@Override
	public String deleteDepartment(long id) {
		
		Department department = departmentRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Department is not present for this id" +id));
				
		departmentRepo.deleteById(id);
		
		return "Successfully deleted department";
	}

}
