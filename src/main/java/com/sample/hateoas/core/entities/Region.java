package com.sample.hateoas.core.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by andresmerida on 4/13/2016.
 */

@Entity
@Table(name = "Region")
public class Region implements Serializable{

    private static final long serialVersionUID = 2685902915574146587L;

    @Id
    @GeneratedValue
    @Column(name = "regionid")
    private Integer regionId;

    private String name;

    private String initials;

    private Boolean deleted;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "countryid")
    private Country country;

    public Region() {}

    public Region(final String name, final String initials, final Boolean deleted,
                  final Country country) {
        this.name           = name;
        this.initials       = initials;
        this.deleted        = deleted;
        this.country        = country;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
