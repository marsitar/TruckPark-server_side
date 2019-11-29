package com.sitarski.truckparkserver.dao;

import com.sitarski.truckparkserver.domain.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findDriverByFullName(String fullName);

    List<Driver> findDriversByFullNameIsLike(String fullName);

    List<Driver> findDriversByCompany_FullName(String companyName);

}
