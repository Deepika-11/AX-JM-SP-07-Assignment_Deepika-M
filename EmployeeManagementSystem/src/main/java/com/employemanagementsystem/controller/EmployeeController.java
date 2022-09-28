package com.employemanagementsystem.controller;


import com.employemanagementsystem.exception.EmployeeIdExistsException;
import com.employemanagementsystem.exception.ErrorResponse;
import com.employemanagementsystem.exception.GlobalExceptionHandler;
import com.employemanagementsystem.exception.InvalidEmployeeIdException;
import com.employemanagementsystem.exception.NodataFoundException;
import com.employemanagementsystem.model.Employee;
import com.employemanagementsystem.repository.EmployeeRepo;
import com.employemanagementsystem.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    
    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/save")
    public ResponseEntity<?> saveEmployeeDetails(@RequestBody Employee employee) {
        if (employeeServiceImpl.saveEmployee(employee) == null) {
            throw new EmployeeIdExistsException();
        }
        return new ResponseEntity<>("Employee data saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeServiceImpl.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") int id) {
        Optional<Employee> employee = employeeServiceImpl.getEmployeeBasedOnId(id);
        if (employee.isEmpty()) {
            throw new InvalidEmployeeIdException();
        }
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

    @GetMapping("/get/salary/{salary}")
    public ResponseEntity<?> getEmployeeBySalary(@PathVariable double salary){
        List<Employee> employee = employeeServiceImpl.getEmployeeBasedOnSalary(salary);
        if (employee.isEmpty()) {
            throw new InvalidEmployeeIdException();
        }
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

    @GetMapping("/get/deptName/{name}")
    public ResponseEntity<?> getEmployeeByDeptName(@PathVariable String name){
        List<Employee> employee = employeeServiceImpl.getEmployeeBasedOnDept(name);
        if (employee.isEmpty()) {
            throw new InvalidEmployeeIdException();
        }
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

	@PutMapping ("/update/id/{id}/name/{name}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable("id") int id, @PathVariable String name){
        if (employeeServiceImpl.updateEmployeeBasedOnId(id, name)) {
        	Employee emp = employeeRepo.getReferenceById(id);
            return new ResponseEntity<>(emp, HttpStatus.FOUND);
        }
        throw new InvalidEmployeeIdException();
    }

    @DeleteMapping("delete/all")
    public ResponseEntity<?> deleteAllEmployees(){
        if(!employeeServiceImpl.deleteAllEmployee())
            throw new NodataFoundException();
        return new ResponseEntity<>("All employee data deleted successfully", HttpStatus.FOUND);
    }
}