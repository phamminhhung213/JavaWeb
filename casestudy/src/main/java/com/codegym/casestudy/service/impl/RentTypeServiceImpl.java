package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.RentType;
import com.codegym.casestudy.repository.RentTypeRepository;
import com.codegym.casestudy.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public RentType findById(Long id) {
        return rentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void remove(Long id) {
        rentTypeRepository.deleteById(id);
    }

    @Override
    public Page<RentType> findAll(Pageable pageable) {
        return rentTypeRepository.findAll(pageable);
    }
}
