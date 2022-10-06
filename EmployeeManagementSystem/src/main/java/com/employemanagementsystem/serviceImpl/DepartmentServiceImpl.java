package com.employemanagementsystem.serviceImpl;

import com.employemanagementsystem.exception.DepartmentIdExistsException;
import com.employemanagementsystem.model.Department;
import com.employemanagementsystem.repository.DepartmentRepo;
import com.employemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public ResponseEntity<?> saveDepartment(Department department) {
        if(departmentRepo.findById(department.getDepartmentId()).isEmpty()){
            departmentRepo.save(department);
            return new ResponseEntity<>("Department data saved successfully", HttpStatus.CREATED);
        }
        throw new DepartmentIdExistsException();
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getDepartmentById(int id) {
        //return departmentRepo.findById(id).isPresent() ? Optional.of(departmentRepo.findById(id).get()) : Optional.empty();
        if(!departmentRepo.findById(id).isPresent())
            throw new DepartmentIdExistsException();
        return departmentRepo.findById(id).get();
    }

   
}
