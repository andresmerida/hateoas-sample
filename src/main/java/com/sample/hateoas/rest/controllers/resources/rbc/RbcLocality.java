package com.sample.hateoas.rest.controllers.resources.rbc;

/**
 * Created by Administrador on 25/04/2016.
 */
public class RbcLocality {

    private String name;
    private String initials;
    private Boolean deleted;
    private String regionId;

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

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
}
