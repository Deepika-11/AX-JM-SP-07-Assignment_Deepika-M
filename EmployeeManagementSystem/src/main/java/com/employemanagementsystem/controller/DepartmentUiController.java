package com.employemanagementsystem.controller;

import java.util.List;

import com.employemanagementsystem.serviceImpl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.employemanagementsystem.exception.InvalidEmployeeIdException;
import com.employemanagementsystem.model.Department;
import com.employemanagementsystem.repository.DepartmentRepo;


@Controller
public class DepartmentUiController {

	
	    @Autowired
	    private DepartmentRepo departmentRepo;

		@Autowired
		private DepartmentServiceImpl departmentServiceImpl;

	    @GetMapping({"/departmentList"})
	    public String getAllDepartments(Model model) {
	        List<Department> listDepartment = departmentRepo.findAll();
	        model.addAttribute("listDepartment", listDepartment);
	        return "list-department";
	    }
	    
	    @GetMapping("/departmentCreate/new")
	    public String showDepartmentNewForm(Model model) {
	    	model.addAttribute("department",new Department());
	    	return "create-department";
	    }
	    
	    @PostMapping("/department/save")
	    public String saveDepartment(Department department) {
	    	departmentRepo.save(department);
	    	return "redirect:/departmentList";
	    }



}
