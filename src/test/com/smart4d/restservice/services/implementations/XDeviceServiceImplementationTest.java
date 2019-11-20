package com.smart4d.restservice.services.implementations;

import com.smart4d.restservice.entities.XDevice;
import com.smart4d.restservice.repositories.XDeviceRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(XDeviceServiceImplementation.class)
public class XDeviceServiceImplementationTest {

    @Mock
    private XDeviceRepository xDeviceRepository;

    @InjectMocks
    private XDeviceServiceImplementation xDeviceServiceImplementation;

    private ArrayList<XDevice> xDevices = new ArrayList<XDevice>(){
        {
            add(new XDevice(1,"device1", "device1_description"){});
            add(new XDevice(2,"device2", "device2_description"){});
        }
    };

    private final XDevice xDevice1 = new XDevice(1,"device1", "device1_description");
    private final XDevice xDevice1_new = new XDevice(1,"device1_new", "device1_new_description");
    private final XDevice xDevice1_updated = new XDevice(1,"device1_updated", "device1_updated_description");

    @Before
    public void setup() {
        when(xDeviceRepository.findAll()).thenReturn(xDevices);
        when(xDeviceRepository.findById(1L)).thenReturn(java.util.Optional.of(xDevice1));
        when(xDeviceRepository.save(xDevice1_new)).thenReturn(xDevice1_new);
        when(xDeviceRepository.save(xDevice1_updated)).thenReturn(xDevice1_updated);
        doNothing().when(xDeviceRepository).deleteById(1L);
    }

    @After
    public void tearDown() {
        reset(xDeviceRepository);
    }

    @Test
    public void testGetAllXDevices(){
        List<XDevice> actualListOfXDevices = xDeviceServiceImplementation.getAllXDevices();

        verify(xDeviceRepository, times(1)).findAll();

        assertThat(actualListOfXDevices.size()).isEqualTo(2);
        assertThat(actualListOfXDevices.get(0).getId()).isEqualTo(xDevice1.getId());
    }

    @Test
    public void testGetXDevice(){
        XDevice actualXDevice = xDeviceServiceImplementation.getXDeviceById(1L);

        verify(xDeviceRepository, times(1)).findById(1L);

        assertThat(actualXDevice.getId()).isEqualTo(1);
        assertThat(actualXDevice.getName()).isEqualTo("device1");
    }

    @Test
    public void testGetXDeviceNotExists(){
        XDevice actualXDevice = xDeviceServiceImplementation.getXDeviceById(2L);

        verify(xDeviceRepository, times(1)).findById(2L);

        assertThat(actualXDevice).isNull();
    }

    @Test
    public void testRegisterXDevice(){
        XDevice actualXDevice = xDeviceServiceImplementation.registerXDevice(xDevice1_new);

        verify(xDeviceRepository, times(1)).save(xDevice1_new);

        assertThat(actualXDevice.getId()).isEqualTo(1);
        assertThat(actualXDevice.getName()).isEqualTo("device1_new");
    }

    @Test
    public void testUpdateXDevice(){
        XDevice actualXDevice = xDeviceServiceImplementation.updateXDevice(1L, xDevice1_updated);

        verify(xDeviceRepository, times(1)).findById(1L);
        verify(xDeviceRepository, times(1)).save(xDevice1_updated);

        assertThat(actualXDevice.getId()).isEqualTo(1);
        assertThat(actualXDevice.getName()).isEqualTo("device1_updated");
    }

    @Test
    public void testDeleteXDevice(){
        boolean actualXDevice = xDeviceServiceImplementation.deleteXDevice(1L);

        verify(xDeviceRepository, times(1)).delete(xDevice1);
        verify(xDeviceRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteXDeviceNotExists(){
        boolean actualXDevice = xDeviceServiceImplementation.deleteXDevice(3L);

        verify(xDeviceRepository, never()).delete(any());
        verify(xDeviceRepository, times(1)).findById(3L);
    }
}
