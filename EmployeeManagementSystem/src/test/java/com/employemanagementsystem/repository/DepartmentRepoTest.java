package com.employemanagementsystem.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.employemanagementsystem.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class DepartmentRepoTest {

	@Autowired
	private DepartmentRepo departmentRepo;

	@Test
	public void testSaveDepartment(){
		Department department = new Department(1,"Auto","KCE");
		departmentRepo.save(department);
	}
	
	@Test
	public void testFindById(){
		Department department = departmentRepo.findById(1).get();
		assertEquals("AUTO", department.getDepartmentName().toUpperCase());
	}
	

}
