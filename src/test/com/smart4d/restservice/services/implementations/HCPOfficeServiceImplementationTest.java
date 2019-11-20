package com.smart4d.restservice.services.implementations;

import com.smart4d.restservice.entities.HCPOffice;
import com.smart4d.restservice.entities.XDevice;
import com.smart4d.restservice.repositories.HCPOfficeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class HCPOfficeServiceImplementationTest {
    /*@Mock
    private HCPOfficeRepository hCPOfficeRepository;

    @InjectMocks
    private HCPOfficeServiceImplementation hCPOfficeServiceImplementation;

    private ArrayList<XDevice> xDevices = new ArrayList<XDevice>(){
        {
            add(new XDevice(1,"device1", "device1_description"){});
            add(new XDevice(2,"device2", "device2_description"){});
        }
    };

    private final HCPOffice hCPOffice = new HCPOffice(1, "HCPOffice","HCPOffice_description", xDevices){};
    private final HCPOffice hCPOffice_new = new HCPOffice(1, "HCPOffice_new","HCPOffice_new_description", xDevices){};
    private final HCPOffice hCPOffice_updated = new HCPOffice(1, "HCPOffice_updated","HCPOffice_updated_description", xDevices){};

    private ArrayList<HCPOffice> hCPOffices = new ArrayList<HCPOffice>(){
        {
            add(hCPOffice);
        }
    };

    @Before
    public void setup() {
        when(hCPOfficeRepository.findAll()).thenReturn(hCPOffices);
        when(hCPOfficeRepository.findById(1L)).thenReturn(java.util.Optional.of(hCPOffice));
        when(hCPOfficeRepository.save(hCPOffice_new)).thenReturn(hCPOffice_new);
        when(hCPOfficeRepository.save(hCPOffice_updated)).thenReturn(hCPOffice_updated);
        doNothing().when(hCPOfficeRepository).deleteById(1L);
    }

    @After
    public void tearDown() {
        reset(hCPOfficeRepository);
    }

    @Test
    public void testGetAllXDevices(){
        List<HCPOffice> actualListOfHCPOffices = hCPOfficeServiceImplementation.getAllHCPOffices();

        verify(hCPOfficeRepository, times(1)).findAll();

        assertThat(actualListOfHCPOffices.size()).isEqualTo(1);
        assertThat(actualListOfHCPOffices.get(0).getId()).isEqualTo(hCPOffice.getId());
    }

    @Test
    public void testGetXDevice(){
        HCPOffice actualHCPOffice = hCPOfficeServiceImplementation.getHCPOfficeById(1L);

        verify(hCPOfficeRepository, times(1)).findById(1L);

        assertThat(actualHCPOffice.getId()).isEqualTo(1);
        assertThat(actualHCPOffice.getName()).isEqualTo("HCPOffice_new");
    }

    @Test
    public void testGetXDeviceNotExists(){
        HCPOffice actualHCPOffice = hCPOfficeServiceImplementation.getHCPOfficeById(2L);

        verify(hCPOfficeRepository, times(1)).findById(2L);

        assertThat(actualHCPOffice).isNull();
    }

    @Test
    public void testRegisterXDevice(){
        HCPOffice actualHCPOffice = hCPOfficeServiceImplementation.registerHCPOffice(hCPOffice_new);

        verify(hCPOfficeRepository, times(1)).save(hCPOffice_new);

        assertThat(actualHCPOffice.getId()).isEqualTo(1);
        assertThat(actualHCPOffice.getName()).isEqualTo("device1_new");
    }

    @Test
    public void testUpdateXDevice(){
        HCPOffice actualHCPOffice = hCPOfficeServiceImplementation.updateHCPOffice(1L, hCPOffice_updated);

        verify(hCPOfficeRepository, times(1)).findById(1L);
        verify(hCPOfficeRepository, times(1)).save(hCPOffice_updated);

        assertThat(actualHCPOffice.getId()).isEqualTo(1);
        assertThat(actualHCPOffice.getName()).isEqualTo("device1_updated");
    }

    @Test
    public void testDeleteXDevice(){
        boolean actualXDevice = hCPOfficeServiceImplementation.deleteHCPOffice(1L);

        verify(hCPOfficeRepository, times(1)).delete(hCPOffice);
        verify(hCPOfficeRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteXDeviceNotExists(){
        boolean actualXDevice = hCPOfficeServiceImplementation.deleteHCPOffice(3L);

        verify(hCPOfficeRepository, never()).delete(any());
        verify(hCPOfficeRepository, times(1)).findById(3L);
    }*/
}
