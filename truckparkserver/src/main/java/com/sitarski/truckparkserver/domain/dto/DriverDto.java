package com.sitarski.truckparkserver.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class DriverDto {

    private Long id;

    private String fullName;

    @JsonIgnore
    private CompanyDto companyDTO;

    @JsonIgnore
	private List<TruckDriverWayDto> truckDriverWaysDTO = new ArrayList<>();

    public DriverDto() {
    }

    public DriverDto(String fullName, CompanyDto companyDTO, List<TruckDriverWayDto> truckDriverWaysDTO) {
        this.fullName = fullName;
        this.companyDTO = companyDTO;
        this.truckDriverWaysDTO = truckDriverWaysDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public CompanyDto getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDto companyDTO) {
        this.companyDTO = companyDTO;
    }

    public List<TruckDriverWayDto> getTruckDriverWaysDTO() {
        return truckDriverWaysDTO;
    }

    public void setTruckDriverWaysDTO(List<TruckDriverWayDto> truckDriverWaysDTO) {
        this.truckDriverWaysDTO = truckDriverWaysDTO;
    }

    @Override
    public String toString() {
        return "DriverDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", companyDTO=" + companyDTO +
                ", truckDriverWaysDTO=" + truckDriverWaysDTO +
                '}';
    }
}
