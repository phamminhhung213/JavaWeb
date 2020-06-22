package com.codegym.baithi.service.impl;


import com.codegym.baithi.model.Part;
import com.codegym.baithi.repository.PartRepository;
import com.codegym.baithi.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl implements PartService {
    @Autowired
    private PartRepository partRepository;

    @Override
    public Part findById(Long id) {
        return partRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Part part) {
        partRepository.save(part);
    }

    @Override
    public void remove(Long id) {
        partRepository.deleteById(id);
    }

    @Override
    public Page<Part> findAll(Pageable pageable) {
        return partRepository.findAll(pageable);
    }
}
