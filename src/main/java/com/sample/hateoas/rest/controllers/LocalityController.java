package com.sample.hateoas.rest.controllers;

import com.sample.hateoas.core.repositories.LocalityRepository;
import com.sample.hateoas.rest.controllers.resources.LocalityResource;
import com.sample.hateoas.rest.controllers.resources.rbc.RbcLocality;
import com.sample.hateoas.core.entities.Locality;
import com.sample.hateoas.core.entities.LocalityPK;
import com.sample.hateoas.core.services.LocalityService;
import com.sample.hateoas.rest.controllers.resources.asm.LocalityResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrador on 25/04/2016.
 */

@RestController
@ExposesResourceFor(LocalityResource.class)
@RequestMapping("/api/localities")
public class LocalityController {

    private final LocalityRepository localityRepository;
    private final LocalityResourceAssembler localityResourceAssembler;
    private final LocalityService localityService;

    @Autowired
    public LocalityController(final LocalityRepository localityRepository,
                              final LocalityResourceAssembler localityResourceAssembler,
                              final LocalityService localityService) {
        this.localityRepository = localityRepository;
        this.localityResourceAssembler = localityResourceAssembler;
        this.localityService = localityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Resources<LocalityResource>> listAllCountries() {
        final Iterable<Locality> localities = localityRepository.findAll();
        final Resources<LocalityResource> wrapped = localityResourceAssembler.toEmbeddedList(localities);
        return ResponseEntity.ok(wrapped);
    }

    @RequestMapping(value = "/{regionId}_{localityId}", method = RequestMethod.GET)
    public ResponseEntity<LocalityResource> showRegion(@PathVariable("regionId") final Integer regionId,
                                                       @PathVariable("localityId") final Integer localityId) {
        final Locality locality = localityRepository.findOne(new LocalityPK(localityId, regionId));
        final LocalityResource resource = localityResourceAssembler.toResource(locality);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> newRegion(@RequestBody RbcLocality rbcLocality) {
        // TODO Add input validation

        Locality locality = localityService.saveLocality(rbcLocality);
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Location", localityResourceAssembler.linkToSingleResource(locality).getHref() );

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
