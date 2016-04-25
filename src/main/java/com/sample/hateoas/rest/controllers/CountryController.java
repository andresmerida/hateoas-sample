package com.sample.hateoas.rest.controllers;

import com.sample.hateoas.core.entities.Country;
import com.sample.hateoas.core.repositories.CountryRepository;
import com.sample.hateoas.core.services.CountryService;
import com.sample.hateoas.rest.controllers.resources.CountryResource;
import com.sample.hateoas.rest.controllers.resources.asm.CountryResourceAssembler;
import com.sample.hateoas.rest.controllers.resources.asm.RegionResourceAssembler;
import com.sample.hateoas.rest.controllers.resources.rbc.NewCountry;
import com.sample.hateoas.rest.controllers.resources.RegionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sample.hateoas.rest.controllers.ResourceHandlingUtils.entityOrNotFoundEx;

/**
 * Created by andresmerida on 4/13/2016.
 */

@RestController
@ExposesResourceFor(CountryResource.class)
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryRepository countryRepository;
    private final CountryResourceAssembler countryResourceAssembler;
    private final RegionResourceAssembler regionResourceAssembler;
    private final CountryService countryService;

    @Autowired
    public CountryController(final CountryRepository countryRepository,
                             final CountryResourceAssembler countryResourceAssembler,
                             final RegionResourceAssembler regionResourceAssembler,
                             final CountryService countryService) {
        this.countryRepository          = countryRepository;
        this.countryResourceAssembler   = countryResourceAssembler;
        this.regionResourceAssembler    = regionResourceAssembler;
        this.countryService             = countryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Resources<CountryResource>> listAllCountries() {
        final Iterable<Country> countries = countryRepository.findAll();
        final Resources<CountryResource> wrapped = countryResourceAssembler.toEmbeddedList(countries);
        return ResponseEntity.ok(wrapped);
    }

    @RequestMapping(value = "/{countryId}", method = RequestMethod.GET)
    public ResponseEntity<CountryResource> getCountry(@PathVariable("countryId") final String countryId) {
        final Country country = entityOrNotFoundEx(countryRepository.findOne(Integer.valueOf(countryId)));
        final CountryResource countryResource = countryResourceAssembler.toResource(country);
        return ResponseEntity.ok(countryResource);
    }

    @RequestMapping(value = "/{countryId}/regions")
    public ResponseEntity<Resources<RegionResource>> listAllRegionsByCountry(@PathVariable("countryId")
                                                                          final String countryId) {
        final Country country = entityOrNotFoundEx(countryRepository.findOne(Integer.valueOf(countryId)));
        final Resources<RegionResource> wrapped = regionResourceAssembler.toEmbeddedList(country.getRegions());
        return ResponseEntity.ok(wrapped);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> newCountry(@RequestBody NewCountry newCountry) {
        Country country = new Country(newCountry.getName(), newCountry.getInitials(),
                newCountry.getDeleted(), newCountry.getEnterpriseId());
        final Country countrySaved = countryService.newCountry(country);
        final HttpHeaders headers = new HttpHeaders();
        System.out.println("estamos en heeeeeeeeeeeeeeeeeeeeeeader.......................");
        headers.add("Location", countryResourceAssembler.linkToSingleResource(countrySaved).getHref());
        System.out.println("pasamos todo okkkkkkkkkkkkkkkkkk .......................");
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
