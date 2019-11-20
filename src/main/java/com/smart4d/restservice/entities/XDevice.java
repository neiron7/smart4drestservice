package com.smart4d.restservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
@NoArgsConstructor
public class XDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "hcpoffice_id")
    @JsonProperty(value = "hcpoffice", access = JsonProperty.Access.WRITE_ONLY)
    private HCPOffice hCPOffice;

    public XDevice(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public XDevice(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @JsonIgnore
    public HCPOffice getHCPOffice() {
        return hCPOffice;
    }
}
