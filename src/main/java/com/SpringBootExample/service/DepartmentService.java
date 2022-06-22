 package com.SpringBootExample.service;

import java.util.List;

import com.SpringBootExample.Error.DepartmentNotFoundException;
import com.SpringBootExample.entity.Department;

public interface DepartmentService {

	public Department saveDep(Department department);

	public List<Department> fetchDepList();

	public Department fetchById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepById(Long departmentId);

	public Department updateDepById(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName); //implementing test for this method

	
}
