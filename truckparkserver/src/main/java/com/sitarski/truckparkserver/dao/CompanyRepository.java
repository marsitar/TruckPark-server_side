package com.sitarski.truckparkserver.dao;

import com.sitarski.truckparkserver.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findAll();

    Optional<Company> findById(Long id);

    Optional<Company> findCompanyByFullName(String fullName);

    boolean existsById(Long id);

    Company save(Company truck);

    void deleteById(Long id);

}
