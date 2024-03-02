package com.example.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.dto.DepartmentDto;
import com.example.ems.service.DepartmentService;

@CrossOrigin
@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto){
		 DepartmentDto savedDepartment = departmentService.createDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable long id){
		
		DepartmentDto departmentDto= departmentService.getDepartment(id);
		return ResponseEntity.ok(departmentDto);
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
		
		List<DepartmentDto> departmentDto= departmentService.getAllDepartment();
		return ResponseEntity.ok(departmentDto);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable long id
			,@RequestBody DepartmentDto departmentDto){
		DepartmentDto updatedDepartmentDto= departmentService.updateDepartment(id, departmentDto);
		
		return ResponseEntity.ok(updatedDepartmentDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
		
		String deleteDepartment= departmentService.deleteDepartment(id);
		
		return ResponseEntity.ok(deleteDepartment);
	}
	
	
	
}
