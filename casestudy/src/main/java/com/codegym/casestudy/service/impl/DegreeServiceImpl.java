package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Degree;
import com.codegym.casestudy.repository.DegreeRepository;
import com.codegym.casestudy.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DegreeServiceImpl implements DegreeService {
    @Autowired
    private DegreeRepository degreeRepository;

    @Override
    public Degree findById(Long id) {
        return degreeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Degree degree) {
        degreeRepository.save(degree);
    }

    @Override
    public void remove(Long id) {
        degreeRepository.deleteById(id);
    }

    @Override
    public Page<Degree> findAll(Pageable pageable) {
        return degreeRepository.findAll(pageable);
    }
}
