package com.codegym.casestudy.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

// Dịch vụ đi kèm
@Entity
@Table(name= "accompany_service")
public class Accompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accompany_id")
    private Long id;
    @Column(name = "accompany_name")
    private String name;
    @Min(value = 0,message = "Phải là số dương")
    private long price;
    private String currency;
    private String status;

    @ManyToOne(targetEntity = ContractDetail.class)
    @JoinColumn(name = "contract_detail_id")
    private ContractDetail contractDetail ;

    public Accompany() {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ContractDetail getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(ContractDetail contractDetail) {
        this.contractDetail = contractDetail;
    }

}
