package com.codegym.casestudy.model;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;

// Hợp đồng chi tiết
@Entity
@Table(name= "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Long id;

    @OneToOne(targetEntity = Contract.class,cascade = ALL)
    @JoinColumn(name="contract_id")
    private Contract contract;

    @OneToMany(targetEntity = Accompany.class,cascade = ALL)
    private List<Accompany> accompanies;

    private int quantity;

    public ContractDetail(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<Accompany> getAccompanies() {
        return accompanies;
    }

    public void setAccompanies(List<Accompany> accompanies) {
        this.accompanies = accompanies;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
