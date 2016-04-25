package com.sample.hateoas.core.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andresmerida on 4/13/2016.
 */

@Entity
@Table(name = "Country")
public class Country implements Serializable {

    private static final long serialVersionUID = 8365902915574146481L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "countryid")
    private Integer countryId;

    private String name;

    private String initials;

    private Boolean deleted;

    @Column(name = "enterpriseid")
    private Integer enterpriseId;

    @OneToMany(mappedBy = "country")
    private List<Region> regions = new ArrayList<>();

    public Country(){}

    public Country(final String name, final String initials, final Boolean deleted, final Integer enterpriseId) {
        this.name           = name;
        this.initials       = initials;
        this.deleted        = deleted;
        this.enterpriseId   = enterpriseId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
