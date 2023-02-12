package com.travelapp.service.impl;

import com.travelapp.model.Category;
import com.travelapp.model.Location;
import com.travelapp.model.exceptions.CategoryNotFoundException;
import com.travelapp.model.exceptions.LocationNotFoundException;
import com.travelapp.repository.CategoryRepository;
import com.travelapp.repository.LocationRepository;
import com.travelapp.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final CategoryRepository categoryRepository;

    public LocationServiceImpl(LocationRepository locationRepository, CategoryRepository categoryRepository) {
        this.locationRepository = locationRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Location findById(Long locationId) {
        return this.locationRepository.findById(locationId).orElseThrow(()->new LocationNotFoundException());
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
    public List<Location> listLocationsByCategory(Long categoryId) {
        Category category;
        if (categoryId != null) {
            category = this.categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new);
        } else {
            category = null;
        }
        if (category != null) {
            return this.locationRepository.findAllByCategoriesContaining(category);
        } else {
            return this.locationRepository.findAll();
        }
    }
}
