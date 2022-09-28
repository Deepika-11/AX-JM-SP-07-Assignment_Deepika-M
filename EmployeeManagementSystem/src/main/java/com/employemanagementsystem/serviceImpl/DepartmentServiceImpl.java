package com.employemanagementsystem.serviceImpl;

import com.employemanagementsystem.model.Department;
import com.employemanagementsystem.repository.DepartmentRepo;
import com.employemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Department saveDepartment(Department department) {
        if(departmentRepo.findById(department.getDepartmentId()).isEmpty()){
            departmentRepo.save(department);
            return department;
        }
        return null;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(int id) {
        return departmentRepo.findById(id).isPresent() ? Optional.of(departmentRepo.findById(id).get()) : Optional.empty();
    }

   
}
