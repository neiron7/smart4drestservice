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
import java.util.Objects;
import java.util.Optional;

@RestController
@Api
@RequestMapping("xDevice")
@Validated
public class XDeviceController {

    private Logger logger = LoggerFactory.getLogger(XDeviceController.class);

    private XDeviceRepository xDeviceRepository;

    @Autowired
    public XDeviceController(XDeviceRepository xDeviceRepository){
        this.xDeviceRepository = xDeviceRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<XDevice>> getAllXDevices(){
        logger.info("Getting list of all XDevices.");
        List<XDevice> listOfXDevices = xDeviceRepository.findAll();
        if (Objects.isNull(listOfXDevices) || listOfXDevices.isEmpty()){
            logger.info("No XDevices found!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            logger.warn("Here is a list of XDevices found:");
            return new ResponseEntity<>(listOfXDevices, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<XDevice> getXDeviceById(@Valid @PathVariable("id") Long id){
        Optional<XDevice> xDeviceInDB = xDeviceRepository.findById(id);
        return xDeviceInDB
                .map(xDevice -> new ResponseEntity<>(xDevice, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<XDevice> registerXDevice(@Valid @RequestBody XDevice xDeviceToBeSaved){
        logger.info("Registering new XDevice.");
        XDevice savedXDevice = xDeviceRepository.save(xDeviceToBeSaved);
        return new ResponseEntity<>(savedXDevice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<XDevice> updateXDevice(@Valid @PathVariable("id") Long id, @RequestBody XDevice xDeviceToBeChanged){
        Optional<XDevice> xDeviceInDB = xDeviceRepository.findById(id);
        if (xDeviceInDB.isPresent()){
            XDevice xDeviceToBeSaved = xDeviceInDB.get();
            xDeviceToBeSaved.setDescription(xDeviceToBeChanged.getDescription());
            xDeviceToBeSaved.setName(xDeviceToBeChanged.getName());
            xDeviceToBeSaved.setHCPOffice(xDeviceToBeChanged.getHCPOffice());
            xDeviceRepository.save(xDeviceToBeSaved);
            return new ResponseEntity<>(xDeviceToBeSaved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteXDevice(@Valid @PathVariable("id") Long id){
        Optional<XDevice> xDeviceInDB = xDeviceRepository.findById(id);
        return xDeviceInDB
                .map(xDevice -> {
                    xDeviceRepository.delete(xDeviceInDB.get());
                    return new ResponseEntity<>(HttpStatus.OK);})
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
//        if (xDeviceInDB.isPresent()){
//            xDeviceRepository.delete(xDeviceInDB.get());
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }
}
