package com.smart4d.restservice.model;



import org.springframework.data.annotation.Id;

import javax.persistence.*;

/**
 * XDeviceModel entity
 */
@Entity
@Table(name = "XDeviceModel")
public class XDeviceModel {

    @Id
    @GeneratedValue(generator = "increment")
    private long id;
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
