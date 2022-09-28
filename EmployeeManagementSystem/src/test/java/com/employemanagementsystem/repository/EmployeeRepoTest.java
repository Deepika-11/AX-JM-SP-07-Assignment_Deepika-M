package com.employemanagementsystem.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.employemanagementsystem.model.Department;
import com.employemanagementsystem.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class EmployeeRepoTest {

	@Autowired
	private EmployeeRepo employeeRepo;

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
	public void testSaveEmployee(){
		Employee employees =
				new Employee(2,"User","Arulmani","S","arulmani@gmail.com","//////",50000.00,"Tamil Nadu",new Department(1,"ECE","KCE"));
		employeeRepo.save(employees);
	}

	@Test
	void getEmployeeById() {
		employeeRepo.save(employee);

		Employee employee1 = employeeRepo.findById(employee.getId()).get();

		assertNotNull(employee1);
	}


}

