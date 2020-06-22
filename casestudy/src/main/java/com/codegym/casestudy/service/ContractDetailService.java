package com.codegym.casestudy.service;

import com.codegym.casestudy.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractDetailService {

    ContractDetail findById(Long id);

    void save(ContractDetail contractDetail);

    void remove(Long id);

    Page<ContractDetail> findAll(Pageable pageable);
}
