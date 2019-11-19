package com.smart4d.restservice.services;

import com.smart4d.restservice.entities.HCPOffice;
import java.util.List;

public interface HCPOfficeService {
    List<HCPOffice> getAllHCPOffices();
    HCPOffice getHCPOfficeById(Long id);
    HCPOffice registerHCPOffice(HCPOffice hCPOfficeToBeSaved);
    HCPOffice updateHCPOffice(Long id, HCPOffice hCPOfficeToBeChanged);
    boolean deleteHCPOffice(Long id);
}
