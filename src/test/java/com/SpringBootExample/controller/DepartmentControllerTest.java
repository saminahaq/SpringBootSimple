package com.SpringBootExample.controller;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.SpringBootExample.entity.Department;
import com.SpringBootExample.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

/*
 * controller layer testing little bit different here we need to hits the end points, by webMVC
 * so we need to mock this MVC
 */

 
@Slf4j
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	private Department department;
	
	//as for the application we are calling controller to service so we ned service layer here 
	
	@MockBean
	private DepartmentService depServ;
	
	@BeforeEach
	void setUp() {
		
		//when the data is persistent we need to put the department Id like here
		Department department = Department.builder()
				.departmentAddress("California")
                .departmentCode("IT")
                .departmentName("SHE")
                .departmentId(1L)
                .build();
		
		
	}

	@Test
	@DisplayName("Test on the addition of data")
	void saveDepartmentSpec() throws Exception {
        Department inputDepartment = Department.builder()
        		.departmentAddress("California")
                .departmentCode("IT")
                .departmentName("SHE")
                .build();

        Mockito.when(depServ.saveDep(inputDepartment))
                .thenReturn(department);  //this from top [private Department department;]

        mockMvc.perform(post("/AddDepartments")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "\t\"departmentName\":\"SHE\",\n" +
                "\t\"departmentAddress\":\"California\",\n" +
                "\t\"departmentCode\":\"IT\"\n" +
                "}"))
                .andExpect(status().isOk());

    }
	@Test
	@DisplayName("Test on the fetchDepartmentByIdSpec byId")
	void fetchDepartmentByIdSpec() throws Exception {
		
		Mockito.when(depServ.fetchById(1L))
				.thenReturn(department);
		
    
		mockMvc.perform(get("/department/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				//.andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
		
		
	
    }

}
