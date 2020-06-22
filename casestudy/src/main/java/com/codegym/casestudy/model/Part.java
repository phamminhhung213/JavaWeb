package com.codegym.casestudy.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

// Phòng ban
@Entity
@Table(name= "part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    private Long id;

    private String part_Name;

    @OneToMany(targetEntity = Employee.class, cascade = ALL)
    private List<Employee> employees;

    public Part() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPart_Name() {
        return part_Name;
    }

    public void setPart_Name(String part_Name) {
        this.part_Name = part_Name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
