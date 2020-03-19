package com.sitarski.truckparkserver.controller;

import com.sitarski.truckparkserver.domain.dto.CompanyDto;
import com.sitarski.truckparkserver.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/companies")
@CrossOrigin("http://localhost:4200")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {

        List<CompanyDto> companyDtoList = companyService.getCompanies();

        return new ResponseEntity<>(companyDtoList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/company/{id}", produces = "application/json")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable("id") Long id) {

        CompanyDto companyDto = companyService.getCompanyById(id)
                .orElse(null);

        return new ResponseEntity<>(companyDto, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/company", consumes = "application/json")
    public ResponseEntity<Object> addCompany(@Valid @RequestBody CompanyDto companyDto) {

        companyService.addCompany(companyDto);

        return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(value = "/company", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CompanyDto> updateCompany(@Valid @RequestBody CompanyDto companyDto) {

        CompanyDto updatedCompanyDto = companyService.updateCompany(companyDto);

        return new ResponseEntity<>(updatedCompanyDto, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/company/{id}", consumes = "text/plain")
    public ResponseEntity<CompanyDto> deleteCompany(@PathVariable("id") Long id) {

        companyService.deleteCompanyById(id);

        return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
    }

}
