package com.smart4d.restservice.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * HCPOffice entity
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class HCPOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hCPOffice")
    private List<XDevice> xDevices = new ArrayList<>();

    public HCPOffice(String name, String description, List<XDevice> xDevices) {
        this.name = name;
        this.description = description;
        this.xDevices = xDevices;
    }

    public HCPOffice(Long id, String name, String description, List<XDevice> xDevices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.xDevices = xDevices;
    }
}
