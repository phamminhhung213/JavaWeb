package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.ContractDetail;

import com.codegym.casestudy.repository.ContractDetailRepository;
import com.codegym.casestudy.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public ContractDetail findById(Long id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return null;
    }
}
