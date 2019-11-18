package com.smart4d.restservice.services;

import com.smart4d.restservice.entities.HCPOffice;
import com.smart4d.restservice.entities.XDevice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface XDeviceService {
    List<XDevice> getAllXDevices();
    XDevice getXDeviceById(Long id);
    XDevice registerXDevice(XDevice xDeviceToBeSaved);
    XDevice updateXDevice(Long id, XDevice xDeviceToBeChanged);
    boolean deleteXDevice(Long id);
}
