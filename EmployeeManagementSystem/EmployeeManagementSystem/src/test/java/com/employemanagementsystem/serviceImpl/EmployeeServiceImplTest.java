package com.employemanagementsystem.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import com.employemanagementsystem.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employemanagementsystem.model.Employee;
import com.employemanagementsystem.repository.EmployeeRepo;


@SpringBootTest
class EmployeeServiceImplTest {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@MockBean
	private EmployeeRepo employeeRepository;

	@BeforeEach
	void setup(){
		Optional<Employee> employee =
				Optional.of(new Employee(1, "eeee","Karpagam",new Department(1)));
		Mockito.when(employeeRepository.findById(1)).thenReturn(employee);
	}

	@Test
	public void testGetEmployeeById() {
		String employee_name = "Karpagam";
		Optional<Employee> employee = employeeService.getEmployeeBasedOnId(1);
		assertEquals(employee_name.toUpperCase(), employee.get().getFirstName().toUpperCase());
	}

}
