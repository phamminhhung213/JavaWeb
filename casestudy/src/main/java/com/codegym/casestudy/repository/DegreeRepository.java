package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DegreeRepository extends JpaRepository<Degree, Long> {
}
