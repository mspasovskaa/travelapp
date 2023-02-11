package com.travelapp.service.impl;

import com.travelapp.model.Location;
import com.travelapp.repository.LocationRepository;
import com.travelapp.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
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
    public List<Location> listLocationsByCategory(String categoryName) {
        return this.locationRepository.findAllByCategory(categoryName);
    }
}
