package com.employemanagementsystem.serviceImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Optional;


import com.employemanagementsystem.model.Department;
import com.employemanagementsystem.repository.DepartmentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.any;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employemanagementsystem.model.Employee;
import com.employemanagementsystem.repository.EmployeeRepo;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepo employeeRepository;

	@Mock
	private DepartmentRepo departmentRepo;

	@InjectMocks
	EmployeeServiceImpl service;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	private Employee employee;
	
	@BeforeEach
	void init() {
		
		employee = new Employee();
		employee.setId(1);
		employee.setRole("Admin");
		employee.setFirstName("Deepika");
		employee.setLastName("Murugesan");
		employee.setEmailId("deepika20@gmail.com");
		employee.setPassword("******");
		employee.setSalary(39999.00);
		employee.setAddress("Tamil Nadu");
		employee.setDepartment(new Department(1));
		
	}

	@Test
	public void testGetEmployeeBasedOnId() {

		when(employeeRepository.findById(any())).thenReturn(Optional.of(employee));

		Optional<Employee> emp = service.getEmployeeBasedOnId(1);

		assertNotNull(emp);
		
	}

	@Test
	public void testUpdateEmployeeBasedOnId(){

		when(employeeRepository.findById(anyInt())).thenReturn(Optional.of(employee));

		employee.setFirstName("Karthik");

		boolean existing = service.updateEmployeeBasedOnId(employee.getId(), employee.getFirstName());

		assertTrue(existing,"Employee Details Updated");
		
	}

	@Test
	void testSave(){

		when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
		when(departmentRepo.findById(any())).thenReturn(Optional.of(new Department()));

		Employee employee1 = service.saveEmployee(employee);

		assertNotNull(employee1);
		assertThat(employee1.getFirstName()).isEqualTo("Deepika");

	}
}