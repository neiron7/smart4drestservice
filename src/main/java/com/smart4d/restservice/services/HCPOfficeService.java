package com.smart4d.restservice.services;

import com.smart4d.restservice.entities.HCPOffice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

@Service
public interface HCPOfficeService {
    List<HCPOffice> getAllHCPOffices();
    HCPOffice getHCPOfficeById(Long id);
    HCPOffice registerHCPOffice(HCPOffice hCPOfficeToBeSaved);
    HCPOffice updateHCPOffice(Long id, HCPOffice hCPOfficeToBeChanged);
    boolean deleteHCPOffice(Long id);
}
