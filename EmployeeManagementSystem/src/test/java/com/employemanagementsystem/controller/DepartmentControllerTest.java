package com.employemanagementsystem.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.employemanagementsystem.serviceImpl.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.employemanagementsystem.model.Department;

import org.mockito.Mockito;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentServiceImpl departmentService;

	@Test
	public void testSaveDepartment() throws Exception{
		Department department = new Department(1,"Auto","KCE");
		when(departmentService.saveDepartment(any())).thenReturn(department);
		String departmentContent = "{\"departmentId\":\"1\",\"departmentName\":\"Auto\",\"collegeName\":\"KCE\"}";
		RequestBuilder builder = MockMvcRequestBuilders.post("/departments/save")
				.accept(MediaType.APPLICATION_JSON)
				.content(departmentContent)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(builder).andExpect(status().isCreated()).andDo(print());
		
	}

	@Test
	public void testGetAllDepartment() throws Exception {
		List<Department> departments = new ArrayList<>(
				Arrays.asList(new Department(2,"Civil","KCE"),
						new Department(3,"CS","KCE"),
						new Department(4,"IT","KCE")));
		when(departmentService.getAllDepartment()).thenReturn(departments);
		mockMvc.perform(get("/departments/get/all")).andExpect(status().isOk()).andDo(print());
	}
	
	

}
