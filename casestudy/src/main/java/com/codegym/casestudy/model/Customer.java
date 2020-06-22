package com.codegym.casestudy.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;


@Entity
@Table(name= "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;

    @NotEmpty(message = "Mã khách hàng không được để trống")
    @Pattern(regexp = "(KH-)[0-9]{4}", message ="Mã Khách hàng có định dạng là KH-XXXX (X là số từ 0-9)" )
    private String codeCustomer;

    @Column
    private String fullName;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column
    @NotEmpty(message = "Chứng minh nhân dân không được để trống")
    @Pattern(regexp = "[0-9]{9}|[0-9]{12}", message ="Chứng minh nhân dân có 9 số hoặc 12 số" )
    private String idNumber;
    @Column
    private String gender;

    @Column
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "(\\(84\\)|0)(90|91)[0-9]{7}", message ="Số ĐT phải có 10 số và bắt đầu bằng số 090/091/(84)90/(84)91" )
    private String phoneNumber;
    @NotEmpty(message = "Không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @Column
    private String address;
    @Column
    private Date dateTime;
    @Column
    private String customerType;
    private String status;

    @OneToMany(targetEntity = Contract.class,cascade = ALL)
    private List<Contract> contracts;

    public Customer() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
