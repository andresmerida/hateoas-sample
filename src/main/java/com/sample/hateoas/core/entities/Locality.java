package com.sample.hateoas.core.entities;

import javax.persistence.*;

@Entity
@Table(name = "Locality")
public class Locality {

    @EmbeddedId
    private LocalityPK localityPk;

    private String name;

    private String initials;

    private Boolean deleted;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "regionid", nullable = false, insertable = false, updatable = false)
    private Region region;

    public Locality() {}

    public Locality(LocalityPK localityPK, String name, String initials, Boolean deleted, Region region) {
        this.localityPk = localityPK;
        this.name = name;
        this.initials = initials;
        this.deleted = deleted;
        this.region = region;
    }

    public LocalityPK getLocalityPk() {
        return localityPk;
    }

    public void setLocalityPk(LocalityPK localityPk) {
        this.localityPk = localityPk;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
