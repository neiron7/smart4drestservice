package com.smart4d.restservice.controllers;

import com.smart4d.restservice.entities.XDevice;
import com.smart4d.restservice.repositories.XDeviceRepository;
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
import java.util.Optional;

@RestController
@Api
@RequestMapping("xDevice")
@Validated
public class XDeviceController {

    Logger logger = LoggerFactory.getLogger(XDeviceController.class);

    @Autowired
    private XDeviceRepository xDeviceRepository;

    public XDeviceController(){super();}

    @GetMapping("/")
    public ResponseEntity<List<XDevice>> getAllXDevices(){

        logger.info("Getting list of all XDevices.");

        List<XDevice> list = xDeviceRepository.findAll();

        if (list == null || list.size() == 0){
            logger.info("No XDevices found!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            logger.info("Here is a list of XDevices found:");
            return new ResponseEntity<List<XDevice>>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<XDevice> getXDeviceById(@Valid @PathVariable("id") Long id){
        Optional<XDevice> xDeviceInDB = xDeviceRepository.findById(id);

        if (xDeviceInDB.isPresent()){
            return new ResponseEntity<XDevice>(xDeviceInDB.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<XDevice> registerXDevice(@Valid @RequestBody XDevice xDeviceToBeSaved){
        logger.info("Registering new XDevice.");

        XDevice savedXDevice = xDeviceRepository.save(xDeviceToBeSaved);

        return new ResponseEntity<XDevice>(savedXDevice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<XDevice> updateXDevice(@Valid @PathVariable("id") Long id, @RequestBody XDevice xDeviceToBeChanged){
        Optional<XDevice> xDeviceInDB = xDeviceRepository.findById(id);

        if (xDeviceInDB.isPresent()){
            XDevice xDeviceToBeSaved = xDeviceInDB.get();
            xDeviceToBeSaved.setDescription(xDeviceToBeChanged.getDescription());
            xDeviceToBeSaved.setName(xDeviceToBeChanged.getName());
            xDeviceRepository.save(xDeviceToBeSaved);
            return new ResponseEntity<XDevice>(xDeviceToBeSaved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteXDevice(@Valid @PathVariable("id") Long id){
        Optional<XDevice> xDeviceInDB = xDeviceRepository.findById(id);

        if (xDeviceInDB.isPresent()){
            xDeviceRepository.delete(xDeviceInDB.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
