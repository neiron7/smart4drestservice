package com.smart4d.restservice.controllers;

import com.smart4d.restservice.entities.HCPOffice;
import com.smart4d.restservice.entities.XDevice;
import com.smart4d.restservice.repositories.HCPOfficeRepository;
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
    private Logger logger = LoggerFactory.getLogger(XDeviceController.class);

    private HCPOfficeRepository hCPOfficeRepository;

    @Autowired
    public HCPOfficeController(HCPOfficeRepository hCPOfficeRepository){
        this.hCPOfficeRepository = hCPOfficeRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<HCPOffice>> getAllHCPOffices(){
        logger.info("Getting list of HCPOffices.");
        List<HCPOffice> listOfHCPOffices = hCPOfficeRepository.findAll();
        if (Objects.isNull(listOfHCPOffices) || listOfHCPOffices.isEmpty()){
            logger.info("No XDevices found!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            logger.warn("Here is a listOfHCPOffices of XDevices found:");
            return new ResponseEntity<>(listOfHCPOffices, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HCPOffice> getHCPOfficeById(@Valid @PathVariable("id") Long id){
        Optional<HCPOffice> hCPOfficeInDB = hCPOfficeRepository.findById(id);
        return hCPOfficeInDB
                .map(hCPOffice -> new ResponseEntity<>(hCPOffice, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<HCPOffice> registerHCPOffice(@Valid @RequestBody HCPOffice hCPOfficeToBeSaved){
        logger.info("Registering new XDevice.");
        HCPOffice savedHCPOffice = hCPOfficeRepository.save(hCPOfficeToBeSaved);
        return new ResponseEntity<>(savedHCPOffice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HCPOffice> updateHCPOffice(@Valid @PathVariable("id") Long id, @RequestBody HCPOffice hCPOfficeToBeChanged){
        Optional<HCPOffice> hCPOfficeInDB = hCPOfficeRepository.findById(id);
        if (hCPOfficeInDB.isPresent()){
            HCPOffice hCPOfficeToBeSaved = hCPOfficeInDB.get();
            hCPOfficeToBeSaved.setDescription(hCPOfficeToBeChanged.getDescription());
            hCPOfficeToBeSaved.setName(hCPOfficeToBeChanged.getName());
            hCPOfficeToBeSaved.setXDevices(hCPOfficeToBeChanged.getXDevices());
            hCPOfficeRepository.save(hCPOfficeToBeSaved);
            return new ResponseEntity<>(hCPOfficeToBeSaved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHCPOffice(@Valid @PathVariable("id") Long id){
        Optional<HCPOffice> hCPOfficeInDB = hCPOfficeRepository.findById(id);
        return hCPOfficeInDB
                .map(hCPOffice -> {
                    hCPOfficeRepository.delete(hCPOfficeInDB.get());
                    return new ResponseEntity<>(HttpStatus.OK);})
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
//        if (hCPOfficeInDB.isPresent()){
//            hCPOfficeRepository.delete(hCPOfficeInDB.get());
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }
}
