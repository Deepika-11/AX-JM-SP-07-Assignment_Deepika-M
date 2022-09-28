package com.employemanagementsystem.controller;

import com.employemanagementsystem.exception.InvalidDepartmentIdException;
import com.employemanagementsystem.model.Department;
import com.employemanagementsystem.serviceImpl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<?> saveDepartmentDetails(@RequestBody Department department) {
        System.out.println(department);
        if (departmentServiceImpl.saveDepartment(department) != null) {
            return new ResponseEntity<>("Department data saved successfully", HttpStatus.CREATED);
        }
        throw new InvalidDepartmentIdException();
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentServiceImpl.getAllDepartment();
        System.out.println(departments);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable("id") int id) {
        Optional<Department> department = departmentServiceImpl.getDepartmentById(id);
        if (department.isEmpty()) {
            throw new InvalidDepartmentIdException();
        }
        return new ResponseEntity<>(department, HttpStatus.FOUND);
    }


}
