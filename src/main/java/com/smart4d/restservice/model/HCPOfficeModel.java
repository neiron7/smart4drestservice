package com.smart4d.restservice.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * HCPOfficeModel entity
 */
@Entity
@Table(name = "HCPOfficeModel")
public class HCPOfficeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<XDeviceModel> xDeviceModels = new ArrayList<XDeviceModel>();

    public HCPOfficeModel() {

    }

    public HCPOfficeModel(long id,String name, String description, List<XDeviceModel> xDeviceModels) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.xDeviceModels = xDeviceModels;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<XDeviceModel> getXDeviceModels() {
        return xDeviceModels;
    }

    public void setXDeviceModels(List<XDeviceModel> xDeviceModels) {
        this.xDeviceModels = xDeviceModels;
    }
}
