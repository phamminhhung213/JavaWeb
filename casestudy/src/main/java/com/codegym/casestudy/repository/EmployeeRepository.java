package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Degree;
import com.codegym.casestudy.model.Employee;
import com.codegym.casestudy.model.Part;
import com.codegym.casestudy.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAllByPart(Part part, Pageable pageable);

    Page<Employee> findAllByDegree(Degree degree, Pageable pageable);

    Page<Employee> findAllByPosition(Position position, Pageable pageable);

    Page<Employee> findByFullNameContaining(String fullName, Pageable pageable);

    Page<Employee> findByPosition_Id(Long id, Pageable pageable);
}
