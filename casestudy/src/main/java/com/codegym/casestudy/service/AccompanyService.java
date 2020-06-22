package com.codegym.casestudy.service;


import com.codegym.casestudy.model.Accompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccompanyService {
    Accompany findById(Long id);

    void save(Accompany accompanyService);

    void remove(Long id);

    Page<Accompany> findAll(Pageable pageable);
}
