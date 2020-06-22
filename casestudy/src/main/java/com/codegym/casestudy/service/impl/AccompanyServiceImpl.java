package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Accompany;
import com.codegym.casestudy.repository.AccompanyRepository;
import com.codegym.casestudy.service.AccompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccompanyServiceImpl implements AccompanyService {
    @Autowired
    private AccompanyRepository accompanyRepository;

    @Override
    public Accompany findById(Long id) {
        return accompanyRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Accompany accompanyService) {
        accompanyRepository.save(accompanyService);
    }

    @Override
    public void remove(Long id) {
        accompanyRepository.deleteById(id);
    }

    @Override
    public Page<Accompany> findAll(Pageable pageable) {
        return accompanyRepository.findAll(pageable);
    }
}
