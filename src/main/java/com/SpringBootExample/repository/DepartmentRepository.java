package com.SpringBootExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringBootExample.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	 public Department findByDepartmentNameIgnoreCase(String departmentName);  //departmentRepositoryTest 
}
