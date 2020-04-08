package com.sitarski.truckparkserver.controller;

import com.sitarski.truckparkserver.domain.dto.TruckDto;
import com.sitarski.truckparkserver.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ResponseStatus(HttpStatus.OK)
    public List<TruckDto> getAllTrucks() {

        List<TruckDto> truckDtoList = truckService.getTrucks();

        return truckDtoList;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TruckDto getTruckById(@PathVariable("id") Long id) {

        TruckDto truckDto = truckService.getTruckById(id)
                .orElse(null);

        return truckDto;
    }

    @PostMapping(value = "/driver", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void addTruck(@Valid @RequestBody TruckDto truckDto) {

        truckService.addTruck(truckDto);
    }

    @PutMapping(value = "/driver", consumes = "application/json" , produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @Valid TruckDto updateTruck(@Valid @RequestBody TruckDto truckDto) {

        TruckDto updatedTruckDto = truckService.updateTruck(truckDto);

        return updatedTruckDto;
    }

    @DeleteMapping(value = "/driver/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTruck(@PathVariable("id") Long id) {

        truckService.deleteTruckById(id);
    }


}
