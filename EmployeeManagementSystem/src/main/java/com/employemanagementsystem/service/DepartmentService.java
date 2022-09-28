package com.employemanagementsystem.service;

import com.employemanagementsystem.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> getAllDepartment();

    Optional<Department> getDepartmentById(int id);

}
