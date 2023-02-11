package com.travelapp.service;

import com.travelapp.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    Optional<Location> findByName(String name);
    List<Location> listLocations();
    List<Location> listLocationsByCategory(String categoryName);
}
