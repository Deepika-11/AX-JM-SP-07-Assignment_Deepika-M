package com.employemanagementsystem.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.employemanagementsystem.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepoTest {

	@Autowired
	private DepartmentRepo departmentRepo;

	@Autowired
	private TestEntityManager testEntityManager;

	@BeforeEach

	void setUp(){
		Department department = new Department(4,"Auto","KCE");
		departmentRepo.save(department);
	}
	
	@Test
	@Rollback(value = false)
	public void testFindById(){
		Department department = departmentRepo.findById(1).get();
		assertEquals("ECE", department.getDepartmentName().toUpperCase());
	}
	

}
