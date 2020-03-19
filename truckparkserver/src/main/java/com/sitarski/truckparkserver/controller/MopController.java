package com.sitarski.truckparkserver.controller;

import com.sitarski.truckparkserver.domain.dto.MopDto;
import com.sitarski.truckparkserver.service.MopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mops")
public class MopController {

    private final MopService mopService;

    @Autowired
    public MopController(MopService mopService) {
        this.mopService = mopService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<MopDto>> getAllMops() {

        List<MopDto> mopDtoList = mopService.getMops();

        return new ResponseEntity<>(mopDtoList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/mop/{id}", produces = "application/json")
    public ResponseEntity<MopDto> getMopById(@PathVariable("id") Long id) {

        MopDto mopDto = mopService.getMopById(id)
                .orElse(null);

        return new ResponseEntity<>(mopDto, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/mop", produces = "application/json")
    public ResponseEntity<MopDto> getMopByIdentificationName(@RequestParam String identificationName) {

        MopDto mopDto = mopService.getMopByIdentificationName(identificationName)
                .orElse(null);

        return new ResponseEntity<>(mopDto, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/allbypattern", produces = "application/json")
    public ResponseEntity<List<MopDto>> getMopsByIdentificationNameIsLike(@RequestParam String identificationNamePattern) {

        List<MopDto> mopDtoList = mopService.getMopsByIdentificationNameIsLike(identificationNamePattern);

        return new ResponseEntity<>(mopDtoList, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/mop", consumes = "application/json")
    public ResponseEntity<Object> addMop(@Valid @RequestBody MopDto mopDto) {

        mopService.addMop(mopDto);

        return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(value = "/mop", consumes = "application/json" , produces = "application/json")
    public ResponseEntity<MopDto> updateMop(@Valid @RequestBody MopDto mopDto) {

        MopDto updatedMopDto = mopService.updateMop(mopDto);

        return new ResponseEntity<>(updatedMopDto, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/mop/{id}", consumes = "text/plain")
    public ResponseEntity<MopDto> deleteMop(@PathVariable("id") Long id) {

        mopService.deleteMopById(id);

        return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
    }
}
