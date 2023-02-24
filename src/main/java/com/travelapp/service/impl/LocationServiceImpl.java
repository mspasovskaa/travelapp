package com.travelapp.service.impl;

import com.travelapp.model.Category;
import com.travelapp.model.Country;
import com.travelapp.model.Location;
import com.travelapp.model.exceptions.CategoryNotFoundException;
import com.travelapp.model.exceptions.CountryNotFoundException;
import com.travelapp.model.exceptions.LocationNotFoundException;
import com.travelapp.repository.CategoryRepository;
import com.travelapp.repository.CountryRepository;
import com.travelapp.repository.LocationRepository;
import com.travelapp.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final CategoryRepository categoryRepository;
    private final CountryRepository countryRepository;

    public LocationServiceImpl(LocationRepository locationRepository, CategoryRepository categoryRepository, CountryRepository countryRepository) {
        this.locationRepository = locationRepository;
        this.categoryRepository = categoryRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Location findById(Long locationId) {
        return this.locationRepository.findById(locationId).orElseThrow(LocationNotFoundException::new);
    }

    @Override
    public Optional<Location> findByName(String name) {
        return this.locationRepository.findByName(name);
    }

    @Override
    public List<Location> listLocations() {
        return this.locationRepository.findAll();
    }

    @Override
    public List<Location> filterByCategoryAndCountry(Long countryId, Long categoryId) {
        Category category = categoryId!=null ? this.categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new) : null;
        Country country = countryId!=null ? this.countryRepository.findById(countryId).orElseThrow(CountryNotFoundException::new) : null;

        if(category!=null && country!=null)
            return this.locationRepository.findAllByCountryAndCategoriesContaining(country, category);
        else if(category!=null)
            return this.locationRepository.findAllByCategoriesContaining(category);
        else if(country!=null)
            return this.locationRepository.findAllByCountry(country);
        else
            return this.locationRepository.findAll();
    }
}
