package com.codegym.casestudy.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;
    @Column
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column
    @NotEmpty(message = "Chứng minh nhân dân không được để trống")
    @Pattern(regexp = "[0-9]{9}|[0-9]{12}", message ="Chứng minh nhân dân có 9 số hoặc 12 số" )
    private String idNumber;

    @Column(name = "phone_number")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "(\\(84\\)\\+|0)(90|91)[0-9]{7}", message ="Số ĐT phải có 10 số và bắt đầu bằng số 090/091/(84)+90/(84)+91" )
    private String phoneNumber;
    private String email;
    private String address;
    @Min(value = 0,message = "Phải là số dương")
    private long salary;
    @ManyToOne(targetEntity = Degree.class)
    @JoinColumn(name = "degree_id")
    private Degree degree;
    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne(targetEntity = Part.class)
    @JoinColumn(name="part_id")
    private Part part;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contractList;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
