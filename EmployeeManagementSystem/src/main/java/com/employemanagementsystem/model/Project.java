package com.employemanagementsystem.model;

import lombok.*;

import java.util.Set;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@Entity
@Table(name="project_table")
public class Project {

    @Id
    private String projectId;
    private String projectName;

    @ManyToMany(fetch=FetchType.EAGER, mappedBy = "project")
    private Set<Employee> employee;

}
