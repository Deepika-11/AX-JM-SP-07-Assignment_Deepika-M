package com.employemanagementsystem.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.employemanagementsystem.serviceImpl.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.employemanagementsystem.model.Department;

import org.mockito.Mockito;

import java.util.Arrays;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentServiceImpl departmentService;

	@Test
	public void testSaveDepartment() throws Exception{
		Department department = new Department(78,"Auto","KCE");
		when(departmentService.saveDepartment(any())).thenReturn(department);
		String departmentContent = "{\"departmentId\":\"79\",\"departmentName\":\"Auto\",\"collegeName\":\"KCE\"}";
		Mockito.when(departmentService.saveDepartment(department)).thenReturn(department);
		RequestBuilder builder = MockMvcRequestBuilders.post("/departments/save")
				.accept(MediaType.APPLICATION_JSON)
				.content(departmentContent)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(builder).andExpect(status().isCreated()).andDo(print());
		
	}

	@Test
	public void testGetAllDepartment() throws Exception {
		when(departmentService.getAllDepartment()).thenReturn(Arrays.asList(new Department()));
		mockMvc.perform(get("/departments/get/all")).andExpect(status().isOk()).andDo(print());
	}

}
