package com.sitarski.truckparkserver.controller;

import com.sitarski.truckparkserver.domain.dto.*;
import com.sitarski.truckparkserver.service.TruckDriverWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/truckdriverways")
@CrossOrigin("http://localhost:4200")
public class TruckDriverWayController {

    private final TruckDriverWayService truckDriverWayService;

    @Autowired
    public TruckDriverWayController(TruckDriverWayService truckDriverWayService) {
        this.truckDriverWayService = truckDriverWayService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<TruckDriverWayDto> getAllTruckDriverWays() {

        List<TruckDriverWayDto> truckDriverWayDtoList = truckDriverWayService.getTruckDriverWays();

        return truckDriverWayDtoList;
    }

    @GetMapping(value = "/truckdriverway/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TruckDriverWayDto getTruckDriverWayById(@PathVariable("id") Long id) {

        TruckDriverWayDto truckDriverWayDto = truckDriverWayService.getTruckDriverWayById(id)
                .orElse(null);

        return truckDriverWayDto;
    }

    @GetMapping(value = "/truckdriverway/driver", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<TruckDriverWayDto> getTruckDriverWaysByDriver(@RequestParam DriverDto driverDto) {

        List<TruckDriverWayDto> truckDriverWaysDto = truckDriverWayService.getTruckDriverWaysByDriver(driverDto);

        return truckDriverWaysDto;
    }

    @GetMapping(value = "/truckdriverway/truck", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<TruckDriverWayDto> getTruckDriverWaysByTruck(@Valid @RequestBody TruckDto truckDto) {

        List<TruckDriverWayDto> truckDriverWaysDto = truckDriverWayService.getTruckDriverWaysByTruck(truckDto);

        return truckDriverWaysDto;
    }

    @GetMapping(value = "/truckdriverway/company", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<TruckDriverWayDto> getTruckDriverWaysByDriversCompany(@Valid @RequestBody CompanyDto companyDto) {

        List<TruckDriverWayDto> truckDriverWaysDto = truckDriverWayService.getTruckDriverWaysByDriversCompany(companyDto);

        return truckDriverWaysDto;
    }

    @GetMapping(value = "/truckdriverway/last/driver/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TruckDriverWayDto getLastTruckDriverWayByDriverId(@PathVariable("id") Long id) {

        TruckDriverWayDto truckDriverWayDto = truckDriverWayService.getLatestTruckDriverWayByDriver(id)
                .orElse(null);

        return truckDriverWayDto;
    }

    @PostMapping(value = "/truckdriverway", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void addTruckDriverWayDto(@Valid @RequestBody TruckDriverWayDtoCreate truckDriverWayDtoCreate) {

        truckDriverWayService.addTruckDriverWay(truckDriverWayDtoCreate);
    }
}
