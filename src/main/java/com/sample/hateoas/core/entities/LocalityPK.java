package com.sample.hateoas.core.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LocalityPK implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "localityid", nullable = false)
    private Integer localityId;

    @Column(name = "regionid", nullable = false)
    private Integer regionId;

    public LocalityPK() {
    }

    public LocalityPK(Integer regionId, Integer localityId) {
        this.regionId = regionId;
        this.localityId = localityId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getLocalityId() {
        return localityId;
    }

    public void setLocalityId(Integer localityId) {
        this.localityId = localityId;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof LocalityPK))
            return false;
        LocalityPK localityPK = (LocalityPK) other;

        return (this.getLocalityId() == localityPK.getLocalityId())
                && (this.getRegionId() == localityPK.getRegionId());
    }

    @Override
    public int hashCode() {
        int result = getLocalityId().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LocalityPk{" +
                " regionId=" + regionId+
                ", localityId=" + localityId +
                '}';
    }
}
