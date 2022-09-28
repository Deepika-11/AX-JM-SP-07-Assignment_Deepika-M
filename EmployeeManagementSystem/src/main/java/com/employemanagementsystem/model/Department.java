/*package com.employemanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "department_table")
public class Department {

    @Id
    private int departmentId;

    private String departmentName;

    private String collegeName;

   // @OneToMany(fetch= FetchType.EAGER, mappedBy = "department")
   // @JsonBackReference
   // private Set<Employee> employee;

   /* public Department(int departmentId, String departmentName, String collegeName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.collegeName = collegeName;
    }

    public Department(int id){
        this.departmentId = id;
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
@Table(name = "department_table")
public class Department {

    @Id
    private int departmentId;

    private String departmentName;

    private String collegeName;

    @OneToMany(fetch= FetchType.EAGER, mappedBy = "department")
    @JsonBackReference
    private Set<Employee> employee;

    public Department(int departmentId, String departmentName, String collegeName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.collegeName = collegeName;
    }

    public Department(int id){
        this.departmentId = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}

