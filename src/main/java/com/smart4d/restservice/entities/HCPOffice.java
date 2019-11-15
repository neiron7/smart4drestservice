package com.smart4d.restservice.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * HCPOffice entity
 */
@Entity
@Table(name = "HCPOffice")
public class HCPOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<XDevice> xDevices = new ArrayList<XDevice>();

    public HCPOffice() {

    }

    public HCPOffice(Long id, String name, String description, List<XDevice> xDevices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.xDevices = xDevices;
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

    public List<XDevice> getXDevices() {
        return xDevices;
    }

    public void setXDevices(List<XDevice> xDevices) {
        this.xDevices = xDevices;
    }
}
