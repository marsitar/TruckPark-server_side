package com.sitarski.truckparkserver.controller;

import com.sitarski.truckparkserver.domain.dto.TruckDto;
import com.sitarski.truckparkserver.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trucks")
@CrossOrigin("http://localhost:4200")
public class TruckController {

    private final TruckService truckService;

    @Autowired
    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping(value = "/all", produces = "application/json")
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
