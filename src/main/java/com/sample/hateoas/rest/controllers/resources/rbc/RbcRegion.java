package com.sample.hateoas.rest.controllers.resources.rbc;

/**
 * Created by andresmerida on 4/21/2016.
 */
public class RbcRegion {

    private String name;
    private String initials;
    private Boolean deleted;
    private String countryId;

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

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
