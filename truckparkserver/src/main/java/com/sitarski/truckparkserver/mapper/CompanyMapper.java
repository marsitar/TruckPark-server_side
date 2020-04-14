package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.domain.dto.CompanyDto;
import com.sitarski.truckparkserver.domain.entity.Company;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyMapper implements Mapper<CompanyDto, Company> {

    @Override
    public CompanyDto convertToDto(Company company) {

        Long id = Optional.of(company)
                .map(Company::getId)
                .orElseThrow();

        String fullName = Optional.of(company)
                .map(Company::getFullName)
                .orElseThrow();

        CompanyDto companyDto = new CompanyDto();

        companyDto.setId(id);
        companyDto.setFullName(fullName);

        return companyDto;
    }

    @Override
    public Company convertToEntity(CompanyDto companyDto) {

        Long id = Optional.of(companyDto)
                .map(CompanyDto::getId)
                .orElseThrow();

        String fullName = Optional.of(companyDto)
                .map(CompanyDto::getFullName)
                .orElseThrow();

        Company company = new Company();

        company.setId(id);
        company.setFullName(fullName);

        return company;
    }
}
