package com.sitarski.truckparkserver.service.mapper;

import com.sitarski.truckparkserver.domain.dto.CompanyDto;
import com.sitarski.truckparkserver.domain.entity.Company;
import com.sitarski.truckparkserver.service.configuration.ModelMapperConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper implements Mapper<CompanyDto, Company> {

    @Autowired
    private final ModelMapperConfiguration modelMapperConfiguration;

    public CompanyMapper(ModelMapperConfiguration modelMapperConfiguration){
        this.modelMapperConfiguration = modelMapperConfiguration;
    }

    @Override
    public CompanyDto convertToDto(Company company){

        CompanyDto companyDto = modelMapperConfiguration.modelMapper().map(company, CompanyDto.class);

        return companyDto;
    }

    @Override
    public Company convertToEntity(CompanyDto companyDto){

        Company company = modelMapperConfiguration.modelMapper().map(companyDto , Company.class);

        return company;
    }
}
