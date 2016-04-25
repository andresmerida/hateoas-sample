package com.sample.hateoas.core.services;

import com.sample.hateoas.core.entities.Locality;
import com.sample.hateoas.rest.controllers.resources.rbc.RbcLocality;

/**
 * Created by Administrador on 25/04/2016.
 */
public interface LocalityService {
    Locality saveLocality(RbcLocality rbcLocality);
    Integer getMaxId();
}
