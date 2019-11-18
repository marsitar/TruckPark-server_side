package com.sitarski.truckparkserver.controller;

import com.sitarski.truckparkserver.domain.dto.TruckDto;
import com.sitarski.truckparkserver.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/trucks")
public class TruckController {

    @Autowired
    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<TruckDto> get(@PathVariable("id") Long id) {

        TruckDto truckDto= truckService.getTruckById(id)
                .orElse(null);

        return new ResponseEntity<>(truckDto, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ResponseEntity<TruckDto[]> get() {

        List<TruckDto> truckDtoList = truckService.getTrucks();

        return new ResponseEntity<>((TruckDto[]) truckDtoList.toArray(), new HttpHeaders(), HttpStatus.OK);
    }
}
