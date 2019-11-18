package com.smart4d.restservice.controllers;

import com.smart4d.restservice.entities.XDevice;
import com.smart4d.restservice.repositories.HCPOfficeRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@WebMvcTest(HCPOfficeController.class)
public class HCPOfficeControllerTest {

    @Mock
    private HCPOfficeRepository hCPOfficeRepo;

    @InjectMocks
    private HCPOfficeController hCPOfficeController;

    private ArrayList<XDevice> xDevices = new ArrayList<XDevice>(){
        {
            add(new XDevice("device1", "device1_desription"){});
            add(new XDevice("device2", "device2_desription"){});
        }
    };

}
