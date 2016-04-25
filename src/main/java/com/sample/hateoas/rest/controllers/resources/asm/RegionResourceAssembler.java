package com.sample.hateoas.rest.controllers.resources.asm;

import com.sample.hateoas.core.entities.Region;
import com.sample.hateoas.rest.controllers.RegionController;
import com.sample.hateoas.rest.controllers.resources.RegionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andresmerida on 4/13/2016.
 */

@Component
public class RegionResourceAssembler extends BaseEmbeddableResourceAssemblerSupport<Region, RegionResource, RegionController>{

    @Autowired
    private CountryResourceAssembler countryResourceAssembler;

    @Autowired
    public RegionResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, RegionController.class, RegionResource.class);
    }

    @Override
    public Link linkToSingleResource(Region region) {
        return entityLinks.linkToSingleResource(RegionResource.class, region.getRegionId().toString());
    }


    @Override
    protected RegionResource instantiateResource(Region entity) {
        return new RegionResource(entity.getName(), entity.getInitials(), entity.getDeleted());
    }

    @Override
    public RegionResource toResource(Region entity) {
        final RegionResource  resource = createResourceWithId(entity.getRegionId().toString(), entity);

        // Create the collection of embeddables of different types
        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
        embeddables.add( countryResourceAssembler.toEmbeddable(entity.getCountry()) );
        resource.setEmbeddeds( new Resources<>(embeddables) ); // Note it must be wrapped in a Resources

        return resource;
    }

    public RegionResource toDetailedResource(Region entity) {
        final RegionResource resource = toBaseResource(entity);
        return resource;
    }

    private RegionResource toBaseResource(Region entity) {
        return createResourceWithId(entity.getRegionId().toString(), entity);
    }
}
