package com.sample.hateoas.core.services.impl;

import com.sample.hateoas.core.entities.Country;
import com.sample.hateoas.core.repositories.CountryRepository;
import com.sample.hateoas.core.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by andresmerida on 4/15/2016.
 */

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional
    public Country newCountry(Country country) {
        return countryRepository.save(country);
    }
}
