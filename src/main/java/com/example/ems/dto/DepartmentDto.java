package com.example.ems.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto {

	private long id;
	private String departmentName;
	private String departmentDescription;
	
	public DepartmentDto() {
		
	}
	
	public DepartmentDto(long id, String departmentName, String departmentDescription) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
	}
	
	
	
}
