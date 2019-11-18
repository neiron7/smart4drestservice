package com.smart4d.restservice.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * XDevice entity
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class XDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long id;

    private String name;

    private String description;

    /*@ManyToOne
    private HCPOffice hCPOffice;*/

    public XDevice(long id, String name, String description/*, HCPOffice hCPOffice*/) {
        this.id = id;
        this.name = name;
        this.description = description;
        /*this.hCPOffice = hCPOffice;*/
    }
}
