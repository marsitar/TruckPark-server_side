package com.sitarski.truckparkserver.controller;

import com.sitarski.truckparkserver.domain.dto.TruckDto;
import com.sitarski.truckparkserver.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trucks")
public class TruckController {

    @Autowired
    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @PostConstruct
    private void postConstruct() {

        List<TruckDto> trucksToAdd = Arrays.asList(new TruckDto(
                "BCAD&HEDDC", "Opel", "Mondeo", 1991, null, null
        ), new TruckDto(
                "DKO8921F89", "Opel", "Astra", 1989, null, null
        ), new TruckDto(
                "PODS78RF64", "Fiat", "Brava", 2001, null, null
        ));

        trucksToAdd.forEach(truckService::addTruck);
    }

    @PreDestroy
    private void preDestroy() {

        truckService.deleteTruckByModel("Brava");
        truckService.deleteTruckByModel("Mondeo");
        truckService.deleteTruckByModel("Astra");
    }

    @GetMapping(value = "/a", produces = "application/json")
    public ResponseEntity<List<TruckDto>> getAllTrucks() {

        List<TruckDto> truckDtoList = truckService.getTrucks();

        return new ResponseEntity<>(truckDtoList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<TruckDto> getTruckById(@PathVariable("id") Long id) {

        TruckDto truckDto = truckService.getTruckById(id)
                .orElse(null);

        return new ResponseEntity<>(truckDto, new HttpHeaders(), HttpStatus.OK);
    }
}
