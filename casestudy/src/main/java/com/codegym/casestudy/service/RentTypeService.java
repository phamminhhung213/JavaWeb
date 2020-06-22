package com.codegym.casestudy.service;

import com.codegym.casestudy.model.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RentTypeService {
    RentType findById(Long id);

    void save(RentType rentType);

    void remove(Long id);

    Page<RentType> findAll(Pageable pageable);
}
