package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {
}
