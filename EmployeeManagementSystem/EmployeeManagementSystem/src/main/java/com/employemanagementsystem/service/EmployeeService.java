package com.employemanagementsystem.service;

import com.employemanagementsystem.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeBasedOnId(int id);

    List<Employee> getEmployeeBasedOnSalary(double salary);

    List<Employee> getEmployeeBasedOnDept(String name);

    /*boolean updateEmployeeBasedOnId(int id, Employee employee);

    boolean deleteEmployeeById(int id);

    boolean deleteAllEmployee();*/



}
