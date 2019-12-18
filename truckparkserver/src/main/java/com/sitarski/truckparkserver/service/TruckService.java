package com.sitarski.truckparkserver.service;

import com.sitarski.truckparkserver.dao.CompanyRepository;
import com.sitarski.truckparkserver.dao.TruckRepository;
import com.sitarski.truckparkserver.domain.dto.TruckDto;
import com.sitarski.truckparkserver.domain.entity.Company;
import com.sitarski.truckparkserver.domain.entity.Truck;
import com.sitarski.truckparkserver.service.mapper.Mapper;
import com.sitarski.truckparkserver.service.mapper.TruckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TruckService {

    @Autowired
    private final TruckRepository truckRepository;

    @Autowired
    private final Mapper<TruckDto,Truck> truckMapper;

    @Autowired
    private final CompanyRepository companyRepository;

    public TruckService(TruckRepository truckRepository, TruckMapper truckMapper, CompanyRepository companyRepository) {
        this.truckRepository = truckRepository;
        this.truckMapper = truckMapper;
        this.companyRepository = companyRepository;
    }

    public List<TruckDto> getTrucks() {

        List<TruckDto> truckDtoList = truckRepository
                .findAll()
                .stream()
                .map(truckMapper::convertToDto)
                .collect(Collectors.toList());

        return truckDtoList;
    }

    public List<TruckDto> getTrucksByCompany(String companyName){

        Optional<Company> company = companyRepository.findCompanyByFullName(companyName);

        List<TruckDto> trucks = truckRepository
                .findTrucksByCompany(company.orElse(null))
                .stream()
                .map(truckMapper::convertToDto)
                .collect(Collectors.toList());

        return trucks;
    }

    public Optional<TruckDto> getTruckById(Long id){

        Optional<TruckDto> truckDto = truckRepository.findById(id)
                .map(truckMapper::convertToDto);

        return truckDto;
    }

    public void addTruck(TruckDto truckDto){

        Truck truckToSave = truckMapper.convertToEntity(truckDto);

        truckRepository.save(truckToSave);
    }

    public void updateTruck(TruckDto truckDto){

        Optional<Truck> optionalTruckToEdit = truckRepository.findById(truckDto.getId());

        if(optionalTruckToEdit.isPresent()){

            Truck truckToSave = optionalTruckToEdit.get();

            truckToSave.setBrand(truckDto.getBrand());
            truckToSave.setCarYear(truckDto.getCarYear());
            truckToSave.setModel(truckDto.getModel());
            truckToSave.setRegistration(truckDto.getRegistration());

            truckRepository.save(truckToSave);
        }
    }

    public void deleteTruckById(Long id){

        truckRepository.deleteById(id);
    }

    public void deleteTruckByModel(String model){

        truckRepository.deleteTruckByModel(model);
    }
}
