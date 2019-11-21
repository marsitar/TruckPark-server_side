package com.sitarski.truckparkserver.dao;

import com.sitarski.truckparkserver.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findCompanyByFullName(String fullName);

}
