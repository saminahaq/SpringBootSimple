package com.SpringBootExample.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootExample.Error.DepartmentNotFoundException;
import com.SpringBootExample.entity.Department;
import com.SpringBootExample.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	/*
	 * so here we need to create the bean of the department repository and autowired them 
	 * then we can call it inside the respective function e.g for saveDep()
	 */
	
	//Step # 03
	
	@Autowired
	public DepartmentRepository deprepo;
	
	
	@Override
	public Department saveDep(Department department) {
		
		return deprepo.save(department); 
	}


	@Override
	public List<Department> fetchDepList() {
		
		return deprepo.findAll();
	}


	@Override
	public Department fetchById(Long departmentId) throws DepartmentNotFoundException {
		
		// return deprepo.findById(departmentId).get(); //because this will give the optional so we need to add the get() method here
		
		Optional<Department> depbyId = deprepo.findById(departmentId);
		
		if (!depbyId.isPresent()) {
			throw new DepartmentNotFoundException("Department not found !!!");
		}
		return depbyId.get();
	}


	
	public void deleteDepById(Long departmentId) {
		deprepo.deleteById(departmentId);
		
	}


	/*
	 * first : get the department by Id
	 * second : check all the data field [except Id] and than update individually 
	 */
	@Override
	public Department updateDepById(Long departmentId, Department department) {
		
		Department depforUpdate = deprepo.findById(departmentId).get();
		


	        if(Objects.nonNull(department.getDepartmentName()) &&
	        !"".equalsIgnoreCase(department.getDepartmentName())) {
	            depforUpdate.setDepartmentName(department.getDepartmentName());
	        }

	       /* if(Objects.nonNull(department.getDepartmentCode()) &&
	                !"".equalsIgnoreCase(department.getDepartmentCode())) {
	            depforUpdate.setDepartmentCode(department.getDepartmentCode());
	        }

	        if(Objects.nonNull(department.getDepartmentAddress()) &&
	                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
	            depforUpdate.setDepartmentAddress(department.getDepartmentAddress());
	        }*/

	        return deprepo.save(depforUpdate);//if all fine to save into the database 
	    

	}


	public Department fetchDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
		
		return deprepo.findByDepartmentNameIgnoreCase(departmentName);
	}


}
