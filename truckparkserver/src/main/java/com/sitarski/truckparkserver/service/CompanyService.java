package com.sitarski.truckparkserver.service;

import com.sitarski.truckparkserver.dao.CompanyRepository;
import com.sitarski.truckparkserver.domain.dto.CompanyDto;
import com.sitarski.truckparkserver.domain.entity.Company;
import com.sitarski.truckparkserver.service.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private final CompanyRepository companyRepository;

    @Autowired
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    public List<CompanyDto> getCompanies() {
        return companyRepository
                .findAll()
                .stream()
                .map(companyMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<CompanyDto> getCompanyById(Long id) {
        return companyRepository
                .findById(id)
                .map(companyMapper::convertToDto);
    }

    public void addCompany(CompanyDto companyDto) {
        Company companyToSave = companyMapper.convertToEntity(companyDto);
        companyRepository.save(companyToSave);
    }

    public CompanyDto updateCompany(CompanyDto companyDto) {
        Company companyToSave = Optional.of(companyDto)
                .map(companyMapper::convertToEntity)
                .orElse(null);

        Company savedCompany = companyRepository.save(companyToSave);

        return companyMapper.convertToDto(savedCompany);
    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

}
