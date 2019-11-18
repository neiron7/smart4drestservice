package com.smart4d.restservice.controllers;

import com.smart4d.restservice.entities.HCPOffice;
import com.smart4d.restservice.entities.XDevice;
import com.smart4d.restservice.repositories.HCPOfficeRepository;
import com.smart4d.restservice.services.HCPOfficeService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@Api
@RequestMapping("hCPOffice")
@Validated
public class HCPOfficeController {

    @Autowired
    HCPOfficeService hCPOfficeService;

    @GetMapping("/")
    public ResponseEntity<List<HCPOffice>> getAllHCPOffices(){
        return Objects.nonNull(hCPOfficeService.getAllHCPOffices()) ? new ResponseEntity<>(hCPOfficeService.getAllHCPOffices(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HCPOffice> getHCPOfficeById(@Valid @PathVariable("id") Long id){
        return Objects.nonNull(hCPOfficeService.getHCPOfficeById(id)) ? new ResponseEntity<>(hCPOfficeService.getHCPOfficeById(id), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<HCPOffice> registerHCPOffice(@Valid @RequestBody HCPOffice hCPOfficeToBeSaved){
        return new ResponseEntity<>(hCPOfficeService.registerHCPOffice(hCPOfficeToBeSaved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HCPOffice> updateHCPOffice(@Valid @PathVariable("id") Long id, @RequestBody HCPOffice hCPOfficeToBeChanged){
        return Objects.nonNull(hCPOfficeService.updateHCPOffice(id, hCPOfficeToBeChanged)) ? new ResponseEntity<>(hCPOfficeService.updateHCPOffice(id, hCPOfficeToBeChanged), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHCPOffice(@Valid @PathVariable("id") Long id){
        if (hCPOfficeService.deleteHCPOffice(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
