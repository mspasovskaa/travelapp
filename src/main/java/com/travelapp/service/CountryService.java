package com.travelapp.service;

import com.travelapp.model.Country;

import java.util.List;

public interface CountryService {
    Country findById(Long countryId);
    List<Country> listCountries();
}
