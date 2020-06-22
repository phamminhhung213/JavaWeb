package com.codegym.casestudy.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
// Hợp đồng
@Entity
@Table(name= "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;

    @ManyToOne(targetEntity = Customer.class,cascade = ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(targetEntity = Services.class,cascade = ALL)
    @JoinColumn(name = "services_id")
    private Services services;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "begin_date")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private Date endDate;
    // tiền cọc
    @Min(value = 0, message = "Tiền cọc phải là số dương")
    private long deposit;
    @Column(name = "total_pay")
    private long totalPay;

    @OneToOne(targetEntity = ContractDetail.class,cascade = ALL)
    private ContractDetail contractDetails;

    public Contract() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(long totalPay) {
        this.totalPay = totalPay;
    }

    public ContractDetail getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(ContractDetail contractDetails) {
        this.contractDetails = contractDetails;
    }
}
