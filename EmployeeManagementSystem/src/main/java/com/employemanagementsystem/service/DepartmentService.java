package com.employemanagementsystem.service;

import com.employemanagementsystem.model.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    ResponseEntity<?> saveDepartment(Department department);

    List<Department> getAllDepartment();

    Department getDepartmentById(int id);

}
