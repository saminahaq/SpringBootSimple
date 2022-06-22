package com.SpringBootExample.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.SpringBootExample.entity.Department;
import com.SpringBootExample.repository.DepartmentRepository;


@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService depServ;
	
	@MockBean   //from mockito
	private DepartmentRepository depRspo;
	
	/*
	 * this setup method we call for each and every test case we are writing here
	 * specially for  providing mock data
	 * 
	 * so under the setup method we need to mock the repository data, and here we are using the builder pattern from the department POJO file
	 */
	//@BeforeAll  //this will execute only one time
	
	
	@BeforeEach
	void setUp() throws Exception {
		//creating mock data for testing, but this record should be present in database 
		
		Department dep = Department
				.builder()
				.departmentName("Finance")
				.departmentAddress("California")
				.departmentCode("IT")
				.departmentId(1L)
				.build();  
		
		
		/*
		 * so when the DepartmentService interface class method fetchDepartmentByName() call 
		 * this above data will return as  the department 
		 */
		
		Mockito.when(depServ.fetchDepartmentByName("Finance")).thenReturn(dep);
		
		
	}

	/*used the Departmentservice bean by autowired
	 * implemention the test case for the interface method "fetchDepartmentByName"
	 * for the test case the method name can be very long and its fine
	 * and add @Test create test case
	 * 
	 * we need to add both scenario positive and negative both  and then validate
	 */
	 

	@Test
	@DisplayName("Get Data based on valid Department name")//for displaying this label on test screen for the better understanding
	//@Disabled //to disabled any particular test case
	void fetchDepartmentByNameSpec() {
		
		//now testing here : and for this method setup will call before that call
		
		String department = "Finance";
		
		Department found = depServ.fetchDepartmentByName(department);
		
		assertEquals(department, found.getDepartmentName() );
	}
}
