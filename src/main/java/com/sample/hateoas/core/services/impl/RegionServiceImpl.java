package com.sample.hateoas.core.services.impl;

import com.sample.hateoas.core.entities.Country;
import com.sample.hateoas.core.entities.Region;
import com.sample.hateoas.core.repositories.CountryRepository;
import com.sample.hateoas.rest.controllers.resources.rbc.RbcRegion;
import com.sample.hateoas.core.repositories.RegionRepository;
import com.sample.hateoas.core.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by andresmerida on 4/21/2016.
 */

@Service
public class RegionServiceImpl implements RegionService{

    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public RegionServiceImpl(final RegionRepository regionRepository, final CountryRepository countryRepository) {
        this.regionRepository = regionRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional
    public Region saveRegion(RbcRegion rbcRegion) {
        Country country = countryRepository.findOne(Integer.valueOf(rbcRegion.getCountryId()));
        return regionRepository.save(new Region(rbcRegion.getName(), rbcRegion.getInitials(),
                rbcRegion.getDeleted(), country));
    }

    @Override
    @Transactional
    public Region editRegion(Integer regionId, RbcRegion rbcRegion) {
        Region region = regionRepository.findOne(regionId);
        region.setName(rbcRegion.getName());
        region.setInitials(rbcRegion.getInitials());

        return regionRepository.save(region);
    }
}
