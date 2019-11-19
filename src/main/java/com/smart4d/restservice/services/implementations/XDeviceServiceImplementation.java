package com.smart4d.restservice.services.implementations;

import com.smart4d.restservice.entities.XDevice;
import com.smart4d.restservice.repositories.HCPOfficeRepository;
import com.smart4d.restservice.repositories.XDeviceRepository;
import com.smart4d.restservice.services.XDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class XDeviceServiceImplementation implements XDeviceService {
    private Logger logger = LoggerFactory.getLogger(XDeviceService.class);

    private XDeviceRepository xDeviceRepository;
    private HCPOfficeRepository hCPOfficeRepository;

    @Autowired
    public XDeviceServiceImplementation(XDeviceRepository xDeviceRepository, HCPOfficeRepository hCPOfficeRepository){
        this.xDeviceRepository = xDeviceRepository;
        this.hCPOfficeRepository = hCPOfficeRepository;
    }

    @Override
    public List<XDevice> getAllXDevices() {
        List<XDevice> listOfXDevices = xDeviceRepository.findAll();
        if (Objects.isNull(listOfXDevices) || listOfXDevices.isEmpty()){
            logger.info("No XDevices found!");
            return null;
        } else {
            logger.warn("Here is a listOfHCPOffices of XDevices found:");
            return listOfXDevices;
        }
    }

    @Override
    public XDevice getXDeviceById(Long id) {
        Optional<XDevice> xDeviceInDB = xDeviceRepository.findById(id);
        return xDeviceInDB.orElse(null);
    }

    @Override
    public XDevice registerXDevice(XDevice xDeviceToBeSaved) {
        XDevice savedXDevice = xDeviceRepository.save(xDeviceToBeSaved);
        return savedXDevice;
    }

    @Override
    public XDevice updateXDevice(Long id, XDevice xDeviceToBeChanged) {
        Optional<XDevice> xDeviceInDB = xDeviceRepository.findById(id);
        if (xDeviceInDB.isPresent()){
            XDevice xDeviceToBeSaved = xDeviceInDB.get();
            xDeviceToBeSaved.setDescription(xDeviceToBeChanged.getDescription());
            xDeviceToBeSaved.setName(xDeviceToBeChanged.getName());
            if (Objects.nonNull(xDeviceToBeChanged.getHCPOffice()) && Objects.nonNull(xDeviceToBeChanged.getHCPOffice().getId())){
                xDeviceToBeSaved.setHCPOffice(hCPOfficeRepository.getOne(xDeviceToBeChanged.getHCPOffice().getId()));
            } else {
                xDeviceToBeSaved.setHCPOffice(xDeviceToBeChanged.getHCPOffice());
            }
            xDeviceRepository.save(xDeviceToBeSaved);
            return xDeviceToBeSaved;
        }
        return null;
    }

    @Override
    public boolean deleteXDevice(Long id) {
        Optional<XDevice> xDeviceInDB = xDeviceRepository.findById(id);
        if (xDeviceInDB.isPresent()){
            xDeviceRepository.delete(xDeviceInDB.get());
            return true;
        }
        return false;
    }
}
