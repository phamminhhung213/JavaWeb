package com.codegym.casestudy.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

//Chức vụ
@Entity
@Table(name= "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long id;

    private String name;

    @OneToMany(targetEntity = Employee.class, cascade = ALL)
    private List<Employee> employees;

    public Position() {
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
