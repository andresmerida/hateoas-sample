package com.sample.hateoas.rest.controllers.resources.asm;

import com.sample.hateoas.core.entities.Locality;
import com.sample.hateoas.rest.controllers.LocalityController;
import com.sample.hateoas.rest.controllers.resources.LocalityResource;
import com.sample.hateoas.rest.controllers.resources.ResourceIdFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocalityResourceAssembler extends BaseEmbeddableResourceAssemblerSupport<Locality, LocalityResource,
        LocalityController> {

    @Autowired
    private RegionResourceAssembler regionResourceAssembler;

    @Autowired
    public LocalityResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, LocalityController.class, LocalityResource.class);
    }

    @Override
    public Link linkToSingleResource(Locality locality) {
        return entityLinks.linkToSingleResource(LocalityResource.class, ResourceIdFactory.getId(locality));
    }

    @Override
    protected LocalityResource instantiateResource(Locality entity) {
        return new LocalityResource(entity.getName(), entity.getInitials(), entity.getDeleted());
    }

    @Override
    public LocalityResource toResource(Locality entity) {
        final LocalityResource resource = toBaseResource(entity);

        // Create the collection of embeddables of different types
        final List<EmbeddedWrapper> embeddables = new ArrayList<>();
        embeddables.add( regionResourceAssembler.toEmbeddable(entity.getRegion()) );
        resource.setEmbeddeds( new Resources<>(embeddables) ); // Note it must be wrapped in a Resources
        return resource;
    }

    private LocalityResource toBaseResource(Locality entity) {
        return createResourceWithId(ResourceIdFactory.getId(entity), entity);
    }
}
