package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.configuration.ModelMapperConfiguration;
import com.sitarski.truckparkserver.dao.CompanyRepository;
import com.sitarski.truckparkserver.dao.DriverRepository;
import com.sitarski.truckparkserver.dao.TruckRepository;
import com.sitarski.truckparkserver.domain.dto.DriverDto;
import com.sitarski.truckparkserver.domain.entity.Company;
import com.sitarski.truckparkserver.domain.entity.Driver;
import com.sitarski.truckparkserver.domain.entity.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DriverMapper implements Mapper<DriverDto, Driver> {

    private final ModelMapperConfiguration modelMapperConfiguration;
    private final CompanyRepository companyRepository;
    private final DriverRepository driverRepository;
    private final TruckRepository truckRepository;

    @Autowired
    public DriverMapper(ModelMapperConfiguration modelMapperConfiguration, CompanyRepository companyRepository, DriverRepository driverRepository, TruckRepository truckRepository){
        this.modelMapperConfiguration = modelMapperConfiguration;
        this.companyRepository = companyRepository;
        this.driverRepository = driverRepository;
        this.truckRepository = truckRepository;
    }

    @Override
    public DriverDto convertToDto(Driver driver) {

        Long companyId = Optional.of(driver)
                .map(Driver::getId)
                .orElseThrow();

        Long truckId = Optional.of(driver)
                .map(Driver::getTruck)
                .map(Truck::getId)
                .orElse(null);

        DriverDto driverDTO = modelMapperConfiguration.modelMapper().map(driver, DriverDto.class);

        driverDTO.setCompanyId(companyId);
        driverDTO.setTruckId(truckId);

        return driverDTO;
    }

    @Override
    public Driver convertToEntity(DriverDto driverDto) {

        Company company = Optional.of(driverDto)
                .map(DriverDto::getCompanyId)
                .flatMap(companyRepository::findById)
                .orElseThrow();

        Truck truck = Optional.of(driverDto)
                .map(DriverDto::getTruckId)
                .flatMap(truckRepository::findById)
                .orElse(null);

        Driver driver = modelMapperConfiguration.modelMapper().map(driverDto, Driver.class);

        driver.setCompany(company);
        driver.setTruck(truck);

        return driver;
    }

    @Override
    public Driver updateEntity(DriverDto driverDto) {

        Driver driverToBeUpdated = Optional.of(driverDto)
                .map(DriverDto::getId)
                .flatMap(driverRepository::findById)
                .orElseThrow();

        String fullName = Optional.of(driverDto)
                .map(DriverDto::getFullName)
                .orElseThrow();

        String firstName = Optional.of(driverDto)
                .map(DriverDto::getFirstName)
                .orElseThrow();

        String surname = Optional.of(driverDto)
                .map(DriverDto::getSurname)
                .orElseThrow();

        String email = Optional.of(driverDto)
                .map(DriverDto::getEmail)
                .orElseThrow();

        String phoneNumber = Optional.of(driverDto)
                .map(DriverDto::getPhoneNumber)
                .orElseThrow();

        LocalDate hireDate = Optional.of(driverDto)
                .map(DriverDto::getHireDate)
                .orElseThrow();

        Truck truck = Optional.of(driverDto)
                .map(DriverDto::getTruckId)
                .flatMap(truckRepository::findById)
                .orElseThrow();

        driverToBeUpdated.setFullName(fullName);
        driverToBeUpdated.setFirstName(firstName);
        driverToBeUpdated.setSurname(surname);
        driverToBeUpdated.setEmail(email);
        driverToBeUpdated.setPhoneNumber(phoneNumber);
        driverToBeUpdated.setHireDate(hireDate);
        driverToBeUpdated.setTruck(truck);

        return driverToBeUpdated;
    }
}
