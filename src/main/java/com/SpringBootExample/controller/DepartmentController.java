package com.SpringBootExample.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import com.SpringBootExample.Error.DepartmentNotFoundException;
import com.SpringBootExample.entity.Department;
import com.SpringBootExample.service.DepartmentService;
import com.SpringBootExample.service.DepartmentServiceImpl;


@RestController
public class DepartmentController {

	/*
	 *                                         public void saveDepartment  
	 * now here as we have the post endpoint so here we are expecting the data, so technically we are getting data as a json std
	 * so we need to convert into the our entity format by putting "@RequestBody"
	 * so whatever the data as a json format converted into the Department entity format
	 * @RequestBody : json to department objects
	 * 
	 * now we want to save this:
	 * so we call the service layer to pass this data  and do business logic [at service layer] and after business login we call the repository layer to save the data 
	 * 
	 * saveDepartment functionality:
	 * 
	 * First : call the service layer to pass the data for business logic
	 * second : do the business logic at service layer
	 * Third : and after business logic, call repository data for saving purpose [at the depertmentServiceImpl]
	 * 
	 * 
	 * 
	 */
	
	//First Step with spring annotation 
	
	@Autowired  //we are telling spring to take department service and make the bean available/attached [loosely coupled] at runtime [property baes autowiring]
	private DepartmentService  depService;

	
	private final Logger  log  = LoggerFactory.getLogger(DepartmentController.class);
	@PostMapping("/AddDepartments")
	public Department saveDepartment(@Valid @RequestBody Department department) { //because we put the validation into the entity = department for the department name , so that's why we are putting here "@valid"
		
		//First Step
		
		// DepartmentService depService = new DepartmentServiceImpl(); //this is old approach, not with spring annotation so, we used spring annotation approach
		
		//second Step : send data to the service for business logic
		
		log.info("Here : Add depertment");
		return depService.saveDep(department); //first create the method signature here "fetchDepList()", than click and create the signature in interface "DepartmentService" class and than create the method in depertmentserviceImp "saveDep()"
	}
	
	
	//Fetch all Department
	
	@GetMapping("/ListDepartments")
	public List<Department> fetchDepartmentList() {
		
		log.info("Here : Fetchdepertment List");
		return depService.fetchDepList(); //first create the method signature here "fetchDepList()", than click and create the signature in interface "DepartmentService" class and than create the method in depertmentserviceImp "fetchDepList()"
	}
	
	
	/*Fetch particular Department : we need to provide the "path variable" {id} and in method signature provide the annotation
	 * @PathVariable("id")
	 * 
	 */
	//Fetch by Id
	@GetMapping("/department/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		
		return depService.fetchById(departmentId); //same here too 

	}
	
	/*
	 * delete by ID
	 */
	
	@DeleteMapping("/delete/department/{id}")
	public String deleteDepertmentById(@PathVariable("id") Long departmentId) {
		
		depService.deleteDepById(departmentId); //same here
		
		return "Sucessfully deleted !!!" ;
	}
	
	/*
	 * updtae data :
	 * so we need to query the dta aby id and update that particular data [two task], than call service layer
	 * @PathVariable("id") Long departmentId :  for identify data
	 * @RequestBody Department department : to updata the data
	 */

	
	@PutMapping("/update/department/{id}")
	public Department updateDepartmentById(@Valid @PathVariable("id") Long departmentId,
									 @Valid @RequestBody Department department) {
		
		return depService.updateDepById(departmentId, department);

	}
	
	@GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return depService.fetchDepartmentByName(departmentName);
    }
	
	
}
