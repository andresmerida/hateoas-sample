package com.sample.hateoas.core.services.impl;

import com.sample.hateoas.core.entities.LocalityPK;
import com.sample.hateoas.core.entities.Region;
import com.sample.hateoas.core.repositories.LocalityRepository;
import com.sample.hateoas.rest.controllers.resources.rbc.RbcLocality;
import com.sample.hateoas.core.entities.Locality;
import com.sample.hateoas.core.repositories.RegionRepository;
import com.sample.hateoas.core.services.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mchoque on 25/04/2016.
 */

@Service
public class LocalityServiceImpl implements LocalityService {

    private final RegionRepository regionRepository;
    private final LocalityRepository localityRepository;

    @Autowired
    public LocalityServiceImpl(final RegionRepository regionRepository, final LocalityRepository localityRepository) {
        this.regionRepository = regionRepository;
        this.localityRepository = localityRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Integer getMaxId() {
        return localityRepository.getMaxId();
    }

    @Override
    @Transactional
    public Locality saveLocality(RbcLocality rbcLocality) {
        Region region = regionRepository.findOne(Integer.valueOf(rbcLocality.getRegionId()));
        LocalityPK localityPK = new LocalityPK(Integer.valueOf(rbcLocality.getRegionId()), this.getMaxId());

        return localityRepository.save(new Locality(localityPK, rbcLocality.getName(), rbcLocality.getInitials(),
                rbcLocality.getDeleted(), region));
    }
}
