package com.employemanagementsystem.serviceImpl;

import com.employemanagementsystem.model.Department;
import com.employemanagementsystem.model.Employee;
import com.employemanagementsystem.repository.DepartmentRepo;
import com.employemanagementsystem.repository.EmployeeRepo;
import com.employemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Employee saveEmployee(Employee employee) {
        Optional<Department> findDeptId = departmentRepo.findById(employee.getDepartment().getDepartmentId());
        if(!findDeptId.isEmpty()) {
            if (employeeRepo.findById(employee.getId()).isEmpty()) {
                employeeRepo.save(employee);
                return employee;
            }
        }
       return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployee = (List<Employee>) employeeRepo.findAll();
        return allEmployee;
    }

    @Override
    public Optional<Employee> getEmployeeBasedOnId(int id) {
            return employeeRepo.findById(id).isPresent() ? Optional.of(employeeRepo.findById(id).get()) : Optional.empty();
        }

    @Override
    public List<Employee> getEmployeeBasedOnSalary(double salary) {
        List<Employee> employees = employeeRepo.getSalary(salary);
        return employees;
    }

    @Override
    public List<Employee> getEmployeeBasedOnDept(String name) {
        List<Employee> employees = employeeRepo.findEmployeeByDeptName(name);
        return employees;
    }

    @Override
    @Transactional
    public boolean updateEmployeeBasedOnId(int id, String name) {
        if(employeeRepo.findById(id).isPresent()) {
            employeeRepo.updateEmployee(name, id);
            return true;
        }
        return  false;
    }

    @Override
    public boolean deleteAllEmployee() {
        if(employeeRepo.findAll().size() > 0) {
            employeeRepo.deleteAll();
            return true;
        }
        return false;
    }

 //   @Override
  //  public boolean checkEmail(String email) {

  //      return employeeRepo.existsByEmail(email);
  //  }

}

