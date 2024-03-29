package com.smart4d.restservice.services.implementations;

import com.smart4d.restservice.entities.HCPOffice;
import com.smart4d.restservice.entities.XDevice;
import com.smart4d.restservice.repositories.HCPOfficeRepository;
import com.smart4d.restservice.services.HCPOfficeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HCPOfficeServiceImplementation implements HCPOfficeService {
    private Logger logger = LoggerFactory.getLogger(HCPOfficeService.class);

    private HCPOfficeRepository hCPOfficeRepository;

    @Autowired
    public HCPOfficeServiceImplementation(HCPOfficeRepository hCPOfficeRepository){
        this.hCPOfficeRepository = hCPOfficeRepository;
    }

    @Override
    public List<HCPOffice> getAllHCPOffices() {
        logger.info("Starting to look over offices!");
        List<HCPOffice> listOfHCPOffices = hCPOfficeRepository.findAll();
        if (Objects.isNull(listOfHCPOffices) || listOfHCPOffices.isEmpty()){
            logger.warn("No offices found!");
            return null;
        } else {
            logger.info("Returning list of offices...");
            return listOfHCPOffices;
        }
    }

    @Override
    public HCPOffice getHCPOfficeById(Long id) {
        Optional<HCPOffice> hCPOfficeInDB = hCPOfficeRepository.findById(id);
        return hCPOfficeInDB.orElse(null);
    }

    @Override
    public HCPOffice registerHCPOffice(HCPOffice hCPOfficeToBeSaved) {
        for (XDevice xDevice : hCPOfficeToBeSaved.getXDevices()){
            xDevice.setHCPOffice((hCPOfficeToBeSaved));
        }
        HCPOffice savedHCPOffice = hCPOfficeRepository.save(hCPOfficeToBeSaved);
        return savedHCPOffice;
    }

    @Override
    public HCPOffice updateHCPOffice(Long id, HCPOffice hCPOfficeToBeChanged) {
        Optional<HCPOffice> hCPOfficeInDB = hCPOfficeRepository.findById(id);
        if (hCPOfficeInDB.isPresent()){
            HCPOffice hCPOfficeToBeSaved = hCPOfficeInDB.get();
            hCPOfficeToBeSaved.setName(hCPOfficeToBeChanged.getName());
            hCPOfficeToBeSaved.setDescription(hCPOfficeToBeChanged.getDescription());
            for (XDevice xDevice : hCPOfficeToBeSaved.getXDevices()){
                xDevice.setHCPOffice((hCPOfficeToBeSaved));
            }
            hCPOfficeToBeSaved.setXDevices(hCPOfficeToBeChanged.getXDevices());
            hCPOfficeRepository.save(hCPOfficeToBeSaved);
            return hCPOfficeToBeSaved;
        }
        return null;
    }

    @Override
    public boolean deleteHCPOffice(Long id) {
        Optional<HCPOffice> hCPOfficeInDB = hCPOfficeRepository.findById(id);
        if (hCPOfficeInDB.isPresent()){
            hCPOfficeRepository.delete(hCPOfficeInDB.get());
            return true;
        }
        return false;
    }
}
