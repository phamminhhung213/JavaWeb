package com.codegym.baithi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column
    @Pattern(regexp = "(NV-)[0-9]{4}", message ="Mã Nhân Viên có định dạng là NV-XXXX (X là số từ 0-9)" )
    private String codeEmployee;

    @Column(name = "full_name")
    private String fullName;
    @Column
    @NotNull
    private String gender;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column
    @NotEmpty(message = "Chứng minh nhân dân không được để trống")
    @Pattern(regexp = "[0-9]{9}", message ="Chứng minh nhân dân có 10 số" )
    private String idNumber;

    @Column(name = "phone_number")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "((090)|(091))[0-9]{7}", message ="Sdt có 10 số,bắt đầu bằng 090/091" )
    private String phoneNumber;
    @Email
    private String email;
    private String address;

    @ManyToOne(targetEntity = Part.class)
    @JoinColumn(name="part_id")
    private Part part;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
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

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}
