/*package com.employemanagementsystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "employee_table")
public class Employee {

    @Id
    private int id;

    private String role;

    private String firstName;

    private String lastName;

    private String emailId;

    private String password;

    private double salary;

    private String address;

    @Transient
    private List<MultipartFile> files = new ArrayList<MultipartFile>();
    
    
    @ManyToOne
    //@JsonManagedReference
    @JoinColumn(name="deptId")
    //@JsonIgnore
    private Department department;

    @ManyToMany
    @JoinColumn(name="projectId")
    @JsonIgnore
    private Set<Project> project;

    public Employee(int employeeId, String role, String employeeFirstName, Department department) {
        this.id = employeeId;
        this.role = role;
        this.firstName = employeeFirstName;
        this.department = department;
    }

	public Employee(int id, String role, String firstName, String lastName, String emailId, String password,
			double salary, String address, Department department) {
		super();
		this.id = id;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.salary = salary;
		this.address = address;
		this.department = department;
	}
    
    

}
*/

package com.employemanagementsystem.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "employee_table")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String role;

    private String firstName;

    private String lastName;

    private String emailId;

    private String password;

    private double salary;

    private String address;

    @ManyToOne
   // @JsonManagedReference
    @JoinColumn(name="deptId")
    private Department department;

    @ManyToMany
    @JoinColumn(name="projectId")
    @JsonIgnore
    private Set<Project> project;

    public Employee(int id, String role, String firstName) {
        this.id = id;
        this.role = role;
        this.firstName = firstName;
    }

    public Employee(int id, String role, String firstName, String lastName, String emailId, String password, double salary, String address, Department department) {
        this.id = id;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.salary = salary;
        this.address = address;
        this.department = department;
    }


}
