package com.employemanagementsystem.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employemanagementsystem.model.Department;
import com.employemanagementsystem.repository.DepartmentRepo;


@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @MockBean
    private DepartmentRepo departmentRepository;

    @BeforeEach
    void setup(){
        Optional<Department> department =
                Optional.of(new Department(1, "eeee","Karpagam"));
        Mockito.when(departmentRepository.findById(1)).thenReturn(department);
    }

    @Test
    public void testGetDepartmentById() {
        String college_name = "Karpagam";
        Optional<Department> department = departmentService.getDepartmentById(1);
        assertEquals(college_name.toUpperCase(), department.get().getCollegeName().toUpperCase());
    }

}
