package com.employemanagementsystem.controller;

import com.employemanagementsystem.model.Employee;
import com.employemanagementsystem.repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AppController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@GetMapping("/")
	public String getHome() {
		return "home";
	}


}
