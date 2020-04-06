package com.sitarski.truckparkserver.controller;

import com.sitarski.truckparkserver.domain.dto.DriverDto;
import com.sitarski.truckparkserver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/drivers")
@CrossOrigin("http://localhost:4200")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<DriverDto> getAllDrivers() {

        List<DriverDto> driverDtoList = driverService.getDrivers();

        return driverDtoList;
    }

    @GetMapping(value = "/driver/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public DriverDto getDriverById(@PathVariable("id") Long id) {

        DriverDto driverDto = driverService.getDriverById(id)
                .orElse(null);

        return driverDto;
    }

    @GetMapping(value = "/driver", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public DriverDto getDriverByIdentificationName(@RequestParam String fullName) {

         DriverDto driverDto = driverService.getDriverByFullName(fullName)
                .orElse(null);

        return driverDto;
    }

    @GetMapping(value = "/allpatterned", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<DriverDto> getAllDriversByPattern(@RequestParam String fullNamePattern) {

        List<DriverDto> driverDtoList = driverService.getDriversByFullNamePattern(fullNamePattern);

        return driverDtoList;
    }

    @PostMapping(value = "/driver", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void addDriver(@Valid @RequestBody DriverDto driverDto) {

        driverService.addDriver(driverDto);
    }

    @PutMapping(value = "/driver", consumes = "application/json" , produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @Valid DriverDto updateDriver(@Valid @RequestBody DriverDto driverDto) {

        DriverDto updatedDriverDto = driverService.updateDriver(driverDto);

        return updatedDriverDto;
    }

    @DeleteMapping(value = "/driver/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDriver(@PathVariable("id") Long id) {

        driverService.deleteDriverById(id);
    }
}
