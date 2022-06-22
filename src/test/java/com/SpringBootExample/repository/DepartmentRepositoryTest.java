package com.SpringBootExample.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.SpringBootExample.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository depRep;
	
	//we need to used the test Entity manager
	@Autowired
	private TestEntityManager entityManager;
	 
	@BeforeEach
	void setUp() throws Exception {
		
		//we need to create mock data, dont add the departmentID() gives error
		
		Department dep = Department.builder()
								.departmentName("SHE")
								.departmentCode("IT")
								.departmentAddress("California")
								.build();  
		
		entityManager.persist(dep); 
		
	}
	
	//now create the test case here

	@Test
	@DisplayName("Get valid Department name based on the valid ID  ")
	void findByDepartmentNameIgnoreCaseSpec() {
	
		Department department = depRep.findById(1L).get();
		
		assertEquals(department.getDepartmentName(), "SHE");
	}

}
