package com.codeclan.example.employeeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "employee_number")
    private int employeeNumber;
    @Column(name = "email")
    private String email;


    @ManyToMany
    @JsonIgnoreProperties({"employees"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "employee_projects",
            joinColumns = { @JoinColumn(
                    name = "employee_id",
                    nullable = false,
                    updatable = false)


            },
            inverseJoinColumns = { @JoinColumn(
                    name = "project_id",
                    nullable = false,
                    updatable = false
            )}
    )

    private List<Project> projects;


    @ManyToOne
    @JoinColumn(name = "department_id", nullable = true)
    @JsonManagedReference
    private Department department;


    public Employee(String name, int age, int employeeNumber, String email, Department department) {
        this.name = name;
        this.age = age;
        this.employeeNumber = employeeNumber;
        this.email = email;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    public Employee(){

    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public  void addProjectToEmployee(Project project){
        this.projects.add(project);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
