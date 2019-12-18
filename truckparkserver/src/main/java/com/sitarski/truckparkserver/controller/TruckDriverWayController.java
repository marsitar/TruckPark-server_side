package com.sitarski.truckparkserver.controller;

import com.sitarski.truckparkserver.domain.dto.*;
import com.sitarski.truckparkserver.service.TruckDriverWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/truckdriverways")
public class TruckDriverWayController {

    @Autowired
    private final TruckDriverWayService truckDriverWayService;

    public TruckDriverWayController(TruckDriverWayService truckDriverWayService) {
        this.truckDriverWayService = truckDriverWayService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<TruckDriverWayDto>> getAllTruckDriverWays() {

        List<TruckDriverWayDto> truckDriverWayDtoList = truckDriverWayService.getTruckDriverWays();

        return new ResponseEntity<>(truckDriverWayDtoList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/truckdriverway/{id}", produces = "application/json")
    public ResponseEntity<TruckDriverWayDto> getTruckDriverWayById(@PathVariable("id") Long id) {

        TruckDriverWayDto truckDriverWayDto = truckDriverWayService.getTruckDriverWayById(id)
                .orElse(null);

        return new ResponseEntity<>(truckDriverWayDto, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/truckdriverwaybydriver", produces = "application/json")
    public ResponseEntity<List<TruckDriverWayDto>> getTruckDriverWaysByDriver(@RequestParam DriverDto driverDto) {

        List<TruckDriverWayDto> truckDriverWaysDto = truckDriverWayService.getTruckDriverWaysByDriver(driverDto);

        return new ResponseEntity<>(truckDriverWaysDto, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/truckdriverwaybytruck", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<TruckDriverWayDto>> getTruckDriverWaysByTruck(@Valid @RequestBody TruckDto truckDto) {

        List<TruckDriverWayDto> truckDriverWaysDto = truckDriverWayService.getTruckDriverWaysByTruck(truckDto);

        return new ResponseEntity<>(truckDriverWaysDto, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/truckdriverwaybycompany", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<TruckDriverWayDto>> getTruckDriverWaysByDriversCompany(@Valid @RequestBody CompanyDto companyDto) {

        List<TruckDriverWayDto> truckDriverWaysDto = truckDriverWayService.getTruckDriverWaysByDriversCompany(companyDto);

        return new ResponseEntity<>(truckDriverWaysDto, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/truckdriverway", consumes = "application/json")
    public ResponseEntity<Object> addTruckDriverWayDto(@Valid @RequestBody TruckDriverWayDtoCreate truckDriverWayDtoCreate) {

        truckDriverWayService.addTruckDriverWay(truckDriverWayDtoCreate);

        return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
    }


}
