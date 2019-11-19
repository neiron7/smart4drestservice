package com.smart4d.restservice.controllers;

import com.smart4d.restservice.entities.XDevice;
import com.smart4d.restservice.services.XDeviceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@Api
@RequestMapping("xDevice")
@Validated
public class XDeviceController {

    @Autowired
    XDeviceService xDeviceService;

    @GetMapping("/")
    public ResponseEntity<List<XDevice>> getAllXDevices(){
        return Objects.nonNull(xDeviceService.getAllXDevices()) ? new ResponseEntity<>(xDeviceService.getAllXDevices(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<XDevice> getXDeviceById(@Valid @PathVariable("id") Long id){
        return Objects.nonNull(xDeviceService.getXDeviceById(id)) ? new ResponseEntity<>(xDeviceService.getXDeviceById(id), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<XDevice> registerXDevice(@Valid @RequestBody XDevice xDeviceToBeSaved){
        return new ResponseEntity<>(xDeviceService.registerXDevice(xDeviceToBeSaved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<XDevice> updateXDevice(@Valid @PathVariable("id") Long id, @RequestBody XDevice xDeviceToBeChanged){
        return Objects.nonNull(xDeviceService.updateXDevice(id, xDeviceToBeChanged)) ? new ResponseEntity<>(xDeviceService.updateXDevice(id, xDeviceToBeChanged), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteXDevice(@Valid @PathVariable("id") Long id){
        if (xDeviceService.deleteXDevice(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
