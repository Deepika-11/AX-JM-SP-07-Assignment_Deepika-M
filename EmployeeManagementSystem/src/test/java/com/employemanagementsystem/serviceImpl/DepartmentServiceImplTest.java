package com.employemanagementsystem.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import com.employemanagementsystem.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.any;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employemanagementsystem.repository.DepartmentRepo;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private DepartmentRepo departmentRepository;

    @InjectMocks
    DepartmentServiceImpl service;
    
    private Department department;

    @BeforeEach
    void setUp() {
        
    }

    @BeforeEach
    void init() {
    	
    	department = new Department();
    	department.setDepartmentId(2);
        department.setDepartmentName("It");
        department.setCollegeName("KCE");

    }


    @Test
    public void testGetDepartmentBasedOnId(){
        
        when(departmentRepository.findById(any())).thenReturn(Optional.of(department));

        Optional<Department> emp = Optional.ofNullable(service.getDepartmentById(1));

        assertNotNull(emp);
        
    }

  
}