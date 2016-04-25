package com.sample.hateoas.core.services;

import com.sample.hateoas.core.entities.Region;
import com.sample.hateoas.rest.controllers.resources.rbc.RbcRegion;

/**
 * Created by andresmerida on 4/21/2016.
 */
public interface RegionService {
    Region saveRegion(RbcRegion rbcRegion);
    Region editRegion(Integer regionId, RbcRegion rbcRegion);
}
