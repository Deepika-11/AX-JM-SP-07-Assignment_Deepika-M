package com.employemanagementsystem.repository;

import com.employemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee_table e inner join department_table d " +
            "on e.id = d.department_id" +
            " where d.department_name=:name",nativeQuery = true)
    List<Employee> findEmployeeByDeptName(String name);
    @Query(value = "select * from employee_table e  where e.salary=:salary",nativeQuery = true)
    List<Employee> getSalary(double salary);
}
