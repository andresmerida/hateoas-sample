package com.sample.hateoas.rest.controllers.resources.asm;

import com.sample.hateoas.core.entities.Country;
import com.sample.hateoas.rest.controllers.CountryController;
import com.sample.hateoas.rest.controllers.resources.CountryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by andresmerida on 4/13/2016.
 */

@Component
public class CountryResourceAssembler extends BaseEmbeddableResourceAssemblerSupport<Country,
        CountryResource, CountryController> {

    @Autowired
    public CountryResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, CountryController.class, CountryResource.class);
    }

    @Override
    public Link linkToSingleResource(Country country) {
        return entityLinks.linkToSingleResource(CountryResource.class, country.getCountryId().toString());
    }

    @Override
    protected CountryResource instantiateResource(Country entity) {
        return new CountryResource(entity.getName(), entity.getInitials(), entity.getDeleted());
    }

    @Override
    public CountryResource toResource(Country entity) {
        final CountryResource  resource = createResourceWithId(entity.getCountryId().toString(), entity);

        // Add link to list of published books
        final Link countryRegionsLink = linkTo( methodOn(CountryController.class)
                .listAllRegionsByCountry(entity.getCountryId().toString()) )
                .withRel("country-regions");
        resource.add(countryRegionsLink);

        return resource;
    }

}
