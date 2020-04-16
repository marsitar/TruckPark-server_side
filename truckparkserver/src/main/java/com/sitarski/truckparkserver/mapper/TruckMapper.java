package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.dao.CompanyRepository;
import com.sitarski.truckparkserver.dao.TruckRepository;
import com.sitarski.truckparkserver.domain.dto.TruckDto;
import com.sitarski.truckparkserver.domain.entity.Company;
import com.sitarski.truckparkserver.domain.entity.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TruckMapper implements Mapper<TruckDto, Truck> {

    private final CompanyRepository companyRepository;
    private final TruckRepository truckRepository;

    @Autowired
    public TruckMapper(CompanyRepository companyRepository, TruckRepository truckRepository){
        this.companyRepository = companyRepository;
        this.truckRepository = truckRepository;
    }

    @Override
    public TruckDto convertToDto(Truck truck) {

        Long id = Optional.of(truck)
                .map(Truck::getId)
                .orElseThrow();

        String registration = Optional.of(truck)
                .map(Truck::getRegistration)
                .orElseThrow();

        String brand = Optional.of(truck)
                .map(Truck::getBrand)
                .orElseThrow();

        String model = Optional.of(truck)
                .map(Truck::getModel)
                .orElseThrow();

        Integer carYear = Optional.of(truck)
                .map(Truck::getCarYear)
                .orElseThrow();

        Long companyId = Optional.of(truck)
            .map(Truck::getCompany)
            .map(Company::getId)
            .orElse(null);

        TruckDto truckDto = new TruckDto();

        truckDto.setId(id);
        truckDto.setRegistration(registration);
        truckDto.setBrand(brand);
        truckDto.setModel(model);
        truckDto.setCarYear(carYear);
        truckDto.setCompanyId(companyId);

        return truckDto;
    }

    @Override
    public Truck convertToEntity(TruckDto truckDto) {

        Long id = Optional.of(truckDto)
                .map(TruckDto::getId)
                .orElseThrow();

        String registration = Optional.of(truckDto)
                .map(TruckDto::getRegistration)
                .orElseThrow();

        String brand = Optional.of(truckDto)
                .map(TruckDto::getBrand)
                .orElseThrow();

        String model = Optional.of(truckDto)
                .map(TruckDto::getModel)
                .orElseThrow();

        Integer carYear = Optional.of(truckDto)
                .map(TruckDto::getCarYear)
                .orElseThrow();

        Company company = Optional.of(truckDto)
            .map(TruckDto::getCompanyId)
            .flatMap(companyRepository::findById)
            .orElseThrow();

        Truck truck = new Truck();

        truck.setId(id);
        truck.setRegistration(registration);
        truck.setBrand(brand);
        truck.setModel(model);
        truck.setCarYear(carYear);
        truck.setCompany(company);

        return truck;
    }

    @Override
    public Truck updateEntity(TruckDto truckDto) {

        String registration = Optional.of(truckDto)
                .map(TruckDto::getRegistration)
                .orElseThrow();

        String model = Optional.of(truckDto)
                .map(TruckDto::getModel)
                .orElseThrow();

        String brand = Optional.of(truckDto)
                .map(TruckDto::getBrand)
                .orElseThrow();

        Integer carYear = Optional.of(truckDto)
                .map(TruckDto::getCarYear)
                .orElseThrow();

        Truck truckToBeUpdated = Optional.of(truckDto)
                .map(TruckDto::getId)
                .flatMap(truckRepository::findById)
                .orElseThrow();

        truckToBeUpdated.setRegistration(registration);
        truckToBeUpdated.setModel(model);
        truckToBeUpdated.setBrand(brand);
        truckToBeUpdated.setCarYear(carYear);

        return truckToBeUpdated;
    }
}
