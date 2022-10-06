package com.employemanagementsystem.controller;


import com.employemanagementsystem.model.Department;
import com.employemanagementsystem.serviceImpl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    @PostMapping("/save")
    public void saveDepartmentDetails(@RequestBody Department department) {
        departmentServiceImpl.saveDepartment(department);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentServiceImpl.getAllDepartment();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/get/id/{id}")
    public void getDepartmentById(@PathVariable("id") int id) {
        departmentServiceImpl.getDepartmentById(id);
    }

}
