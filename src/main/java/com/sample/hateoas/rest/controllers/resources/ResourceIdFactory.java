package com.sample.hateoas.rest.controllers.resources;

import com.sample.hateoas.core.entities.Locality;

public abstract class ResourceIdFactory {
    public static String getId(Locality locality) {
        return locality.getLocalityPk().getRegionId()+"_"+locality.getLocalityPk().getLocalityId();
    }
}
