package com.employemanagementsystem.controller;

import com.employemanagementsystem.model.Employee;
import com.employemanagementsystem.repository.EmployeeRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmployeeUiController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping({"/employeeList"})
    public String getAllEmployees(Model model) {
        List<Employee> listEmployees = employeeRepo.findAll();
        model.addAttribute("listEmployees", listEmployees);
        return "list-employees";
    }
    
    @GetMapping("/employeeCreate/new")
    public String showEmployeeNewForm(Model model) {
    	model.addAttribute("employee",new Employee());
    	return "create-employees";
    }
    
    @PostMapping("/employee/save")
    public String saveEmployee(Employee employee) {
    	employeeRepo.save(employee);
    	return "redirect:/employeeList";
    }
}
