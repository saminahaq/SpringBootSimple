package com.SpringBootExample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootExampleApplicationTests {

	/*
	 * For testing start with the service layer than repository and than controller layer 
	 * this style is the simplest way to create the test cases, go for the each layer
	 * 
	 *  First Step : go to the DepartmentService interface class  for making test class
	 * 
	 * on proj explorer :  right-click the class you want to test and click New → JUnit Test Case. 
	 * 
	 * add @SpringBootTest on top of class
	 * 
	 * for the ServiceLayer test see : DEpartmentSrviceTest
	 * 
	 * for repository layer test see : 
	 * 
	 * we can used @ JPA test repository for repository test : so we used data and then data is done the data flushed out
	 * we also create the database for the testing as well
	 * 
	 * go to the DepartmentRepository interface class  for making test class
	 * 
	 * 
	 * now create the test for the controller layer  see :DepartmentControllerTest
	 */
	
	
	
	
	
}
