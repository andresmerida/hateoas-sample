package com.sample.hateoas.rest.controllers;

import com.sample.hateoas.core.entities.Region;
import com.sample.hateoas.core.repositories.RegionRepository;
import com.sample.hateoas.core.services.RegionService;
import com.sample.hateoas.rest.controllers.resources.RegionResource;
import com.sample.hateoas.rest.controllers.resources.asm.RegionResourceAssembler;
import com.sample.hateoas.rest.controllers.resources.rbc.RbcRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by andresmerida on 4/18/2016.
 * testing edit from web
 */

@RestController
@ExposesResourceFor(RegionResource.class)
@RequestMapping("/api/regions")
public class RegionController {

    private final RegionRepository regionRepository;
    private final RegionResourceAssembler regionResourceAssembler;
    private final RegionService regionService;

    @Autowired
    public RegionController(final RegionRepository regionRepository,
                            final RegionResourceAssembler regionResourceAssembler,
                            final RegionService regionService) {
        this.regionRepository = regionRepository;
        this.regionResourceAssembler = regionResourceAssembler;
        this.regionService = regionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Resources<RegionResource>> listAllRegions() {
        final Iterable<Region> regions = regionRepository.findAll();
        final Resources<RegionResource> wrapped = regionResourceAssembler.toEmbeddedList(regions);
        return ResponseEntity.ok(wrapped);
    }

    @RequestMapping(value = "/{regionId}", method = RequestMethod.GET)
    public ResponseEntity<RegionResource> showRegion(@PathVariable("regionId") final Integer regionId) {
        final Region region = regionRepository.findOne(regionId);
        final RegionResource resource = regionResourceAssembler.toResource(region);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> newRegion(@RequestBody RbcRegion rbcRegion) {
        // TODO Add input validation

        Region region = regionService.saveRegion(rbcRegion);
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Location", regionResourceAssembler.linkToSingleResource(region).getHref() );

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{regionId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> editRegion(@PathVariable("regionId") final Integer regionId,
                                           @RequestBody RbcRegion rbcRegion) {
        // TODO Add input validation to edit
        Region regionEdited = regionService.editRegion(regionId, rbcRegion);
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Location", regionResourceAssembler.linkToSingleResource(regionEdited).getHref() );
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}
