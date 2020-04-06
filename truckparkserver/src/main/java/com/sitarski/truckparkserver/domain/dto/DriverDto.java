package com.sitarski.truckparkserver.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DriverDto {

    private Long id;

    @Length(min = 3, max = 20, message = "Nieprawidlowa liczba znakow")
    private String fullName;

    @Length(min = 3, max = 20, message = "Nieprawidlowa liczba znakow")
    private String firstName;

    @Length(min = 3, max = 20, message = "Nieprawidlowa liczba znakow")
    private String surname;

    @Email(message = "Email w nieprawidlowym formacie")
    private String email;

    @Length(min = 6, max = 12, message = "Nieprawidlowa liczba znakow")
    private String phoneNumber;

    @NotNull
    private LocalDate hireDate;

    private Long truckId;

    private Long companyId;

    @JsonIgnore
    private List<TruckDriverWayDto> truckDriverWaysDTO = new ArrayList<>();

    public DriverDto() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public List<TruckDriverWayDto> getTruckDriverWaysDTO() {
        return truckDriverWaysDTO;
    }

    public void setTruckDriverWaysDTO(List<TruckDriverWayDto> truckDriverWaysDTO) {
        this.truckDriverWaysDTO = truckDriverWaysDTO;
    }
}
