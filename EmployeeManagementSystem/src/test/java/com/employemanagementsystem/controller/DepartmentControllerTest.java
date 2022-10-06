package com.employemanagementsystem.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

import com.employemanagementsystem.serviceImpl.DepartmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.employemanagementsystem.model.Department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentServiceImpl departmentService;

	private Department department;

	@Test
	public void testSaveDepartment() throws Exception{
		when(departmentService.saveDepartment(any(Department.class))).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));
		String departmentContent = "{\"departmentId\":\"1\",\"departmentName\":\"Auto\",\"collegeName\":\"KCE\"}";
		RequestBuilder builder = MockMvcRequestBuilders.post("/departments/save")
				.accept(MediaType.APPLICATION_JSON)
				.content(departmentContent)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(builder).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testGetAllDepartment() throws Exception {
		List<Department> departments = new ArrayList<>(
				Arrays.asList(new Department(2,"Civil","KCE"),
						new Department(3,"CS","KCE"),
						new Department(4,"IT","KCE")));
		when(departmentService.getAllDepartment()).thenReturn(departments);
		mockMvc.perform(get("/departments/get/all"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(departments.size())));
	}
	
	@Test
	void testGetById() throws Exception {
		department = new Department(1,"Civil","KCE");
		when(departmentService.getDepartmentById(anyInt())).thenReturn(department);
		mockMvc.perform(get("/departments/get/id/{id}",1))
				.andReturn().getResponse().getContentAsString();
	}

}
