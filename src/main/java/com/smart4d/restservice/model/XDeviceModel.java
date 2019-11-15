package com.smart4d.restservice.model;



import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * XDeviceModel entity
 */
@Entity
@Table(name = "XDeviceModel")
public class XDeviceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Object hCPOffice;

    public XDeviceModel() {

    }

    public XDeviceModel(long id,String name, String description, Object hCPOffice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hCPOffice = hCPOffice;
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

    public Object gethCPOffice() {
        return hCPOffice;
    }

    public void setHCPOffice(String hCPOffice) {
        this.hCPOffice = hCPOffice;
    }
}
