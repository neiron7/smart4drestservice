package com.smart4d.restservice.services;

import com.smart4d.restservice.entities.XDevice;
import java.util.List;

public interface XDeviceService {
    List<XDevice> getAllXDevices();
    XDevice getXDeviceById(Long id);
    XDevice registerXDevice(XDevice xDeviceToBeSaved);
    XDevice updateXDevice(Long id, XDevice xDeviceToBeChanged);
    boolean deleteXDevice(Long id);
}
