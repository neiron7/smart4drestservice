package com.smart4d.restservice.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * XDevice entity
 */
@Entity
@Table(name = "XDevice")
public class XDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", nullable = false)
    private String description;

    @ManyToOne(targetEntity = HCPOffice.class)
    private HCPOffice hCPOffice;

    public XDevice() {

    }

    public XDevice(long id, String name, String description, HCPOffice hCPOffice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hCPOffice = hCPOffice;
    }

    public Long getId() {
        return id;
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

    public void setHCPOffice(HCPOffice hCPOffice) {
        this.hCPOffice = hCPOffice;
    }
}
