package com.sitarski.truckparkserver.controller;

import com.sitarski.truckparkserver.domain.dto.TruckDto;
import com.sitarski.truckparkserver.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

        TruckDto truck1 = new TruckDto(
                "BCAD&HEDDC", "Opel", "Mondeo", 1991, null, null
        );

        TruckDto truck2 = new TruckDto(
                "DKO8921F89", "Opel", "Astra", 1989, null, null
        );

        TruckDto truck3 = new TruckDto(
                "PODS78RF64", "Fiat", "Brava", 2001, null, null
        );

        truckService.addTruck(truck1);
        truckService.addTruck(truck2);
        truckService.addTruck(truck3);
    }

    @PreDestroy
    private void preDestroy() {

        truckService.deleteTruckByModel("Brava");
        truckService.deleteTruckByModel("Mondeo");
        truckService.deleteTruckByModel("Astra");
    }

    @GetMapping(value="/a", produces = "application/json")
    public ResponseEntity<List<TruckDto>> getAllTrucks() {

        List<TruckDto> truckDtoList = truckService.getTrucks();

        return new ResponseEntity<>(truckDtoList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}", produces = "application/json")
    public ResponseEntity<TruckDto> getTruckById(@PathVariable("id") Long id) {

        TruckDto truckDto= truckService.getTruckById(id)
                .orElse(null);

        return new ResponseEntity<>(truckDto, new HttpHeaders(), HttpStatus.OK);
    }
}
