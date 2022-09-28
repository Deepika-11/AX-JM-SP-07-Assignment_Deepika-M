package com.employemanagementsystem.controller;

import com.employemanagementsystem.exception.InvalidEmployeeIdException;
import com.employemanagementsystem.model.Employee;
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

    @PostMapping("/save")
    public ResponseEntity<?> saveEmployeeDetails(@RequestBody Employee employee) {
        if (employeeServiceImpl.saveEmployee(employee) == null) {
            throw new InvalidEmployeeIdException();
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

   /* @PutMapping("/update/id/{id}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable("id") int id, @RequestBody Employee employee){
        System.out.println(id+" "+employee);
        if (employeeServiceImpl.updateEmployeeBasedOnId(id, employee)) {
            return new ResponseEntity<>(employee, HttpStatus.FOUND);
        }
        return new InvalidEmployeeIdException("Couldn't update because Employee id is not found").handleEmployeeException();
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable int id){
        if(!employeeServiceImpl.deleteEmployeeById(id))
            return new InvalidEmployeeIdException("The given employee id is not present").handleEmployeeException();
        return new ResponseEntity<>("Employee data deleted successfully", HttpStatus.FOUND);
    }

    @DeleteMapping("delete/all")
    public ResponseEntity<?> deleteAllEmployees(){
        if(!employeeServiceImpl.deleteAllEmployee())
            return new InvalidEmployeeIdException("There is no employee detail found").handleEmployeeException();
        return new ResponseEntity<>("All employee data deleted successfully", HttpStatus.FOUND);
    }*/
}