package com.codegym.casestudy.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

// Trình độ
@Entity
@Table(name= "degree")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "degree_id")
    private Long id;

    private String nameDegree;

    @OneToMany(targetEntity = Employee.class,cascade = ALL)
    private List<Employee> employees;

    public Degree() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDegree() {
        return nameDegree;
    }

    public void setNameDegree(String nameDegree) {
        this.nameDegree = nameDegree;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
