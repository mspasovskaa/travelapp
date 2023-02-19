package com.travelapp.service.impl;

import com.travelapp.model.Country;
import com.travelapp.model.exceptions.CountryNotFoundException;
import com.travelapp.repository.CountryRepository;
import com.travelapp.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country findById(Long countryId) {
        return this.countryRepository.findById(countryId).orElseThrow(CountryNotFoundException::new);
    }

    @Override
    public List<Country> listCountries() {
        return this.countryRepository.findAll();
    }
}
