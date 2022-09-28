package com.employemanagementsystem.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.employemanagementsystem.serviceImpl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.employemanagementsystem.model.Employee;
import com.employemanagementsystem.repository.EmployeeRepo;

import org.mockito.Mockito;

import java.util.Arrays;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeServiceImpl employeeService;
	
	@MockBean
	private EmployeeRepo employeeRepo;

	@Test
	public void testSaveEmployee() throws Exception{
		Employee employee = new Employee(1,"Admin","Deepika");
		when(employeeService.saveEmployee(any())).thenReturn(employee);
		String employeeContent = "{\"employeeId\":\"1\",\"role\":\"Admin\",\"employeeFirstName\":\"Deepika\"}";
		Mockito.when(employeeService.saveEmployee(employee)).thenReturn(employee);
		RequestBuilder builder = MockMvcRequestBuilders.post("/employees/save")
				.accept(MediaType.APPLICATION_JSON)
				.content(employeeContent)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(builder).andExpect(status().isCreated()).andDo(print());

	}

	@Test
	public void testGetAllEmployee() throws Exception {
		when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(new Employee()));
		mockMvc.perform(get("/employees/get/all")).andExpect(status().isOk()).andDo(print());
	}

}
