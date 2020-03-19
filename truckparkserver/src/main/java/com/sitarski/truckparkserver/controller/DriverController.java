package com.sitarski.truckparkserver.controller;

import com.sitarski.truckparkserver.domain.dto.DriverDto;
import com.sitarski.truckparkserver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<DriverDto>> getAllDrivers() {

        List<DriverDto> driverDtoList = driverService.getDrivers();

        return new ResponseEntity<>(driverDtoList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/driver/{id}", produces = "application/json")
    public ResponseEntity<DriverDto> getDriverById(@PathVariable("id") Long id) {

        DriverDto driverDto = driverService.getDriverById(id)
                .orElse(null);

        return new ResponseEntity<>(driverDto, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/driver", produces = "application/json")
    public ResponseEntity<DriverDto> getDriverByIdentificationName(@RequestParam String fullName) {

        DriverDto driverDto = driverService.getDriverByFullName(fullName)
                .orElse(null);

        return new ResponseEntity<>(driverDto, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/allpatterned", produces = "application/json")
    public ResponseEntity<List<DriverDto>> getAllDriversByPattern(@RequestParam String fullNamePattern) {

        List<DriverDto> driverDtoList = driverService.getDriversByFullNamePattern(fullNamePattern);

        return new ResponseEntity<>(driverDtoList, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/driver", consumes = "application/json")
    public ResponseEntity<Object> addDriver(@Valid @RequestBody DriverDto driverDto) {

        driverService.addDriver(driverDto);

        return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(value = "/driver", consumes = "application/json" , produces = "application/json")
    public ResponseEntity<DriverDto> updateDriver(@Valid @RequestBody DriverDto driverDto) {

        DriverDto updatedDriverDto = driverService.updateDriver(driverDto);

        return new ResponseEntity<>(updatedDriverDto, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/driver/{id}", consumes = "text/plain")
    public ResponseEntity<DriverDto> deleteDriver(@PathVariable("id") Long id) {

        driverService.deleteDriverById(id);

        return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
    }
}
