package com.travelapp.config;

import com.travelapp.model.Country;
import com.travelapp.model.Location;
import com.travelapp.repository.CategoryRepository;
import com.travelapp.repository.CountryRepository;
import com.travelapp.repository.LocationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final CategoryRepository categoryRepository;
    private final CountryRepository countryRepository;
    private final LocationRepository locationRepository;

    public DataInitializer(CategoryRepository categoryRepository, CountryRepository countryRepository, LocationRepository locationRepository) {
        this.categoryRepository = categoryRepository;
        this.countryRepository = countryRepository;
        this.locationRepository = locationRepository;
    }

    @PostConstruct
    public void initData(){
        countryRepository.save(new Country("Macedonia", "MK Desc", "https://i.ibb.co/60zNZds/Macedonia.png", null));
        countryRepository.save(new Country("Serbia", "SRB Desc", "https://i.ibb.co/rfFCfwv/Serbia.png", null));
        countryRepository.save(new Country("Greece", "GR Desc", "https://i.ibb.co/vw0CP2j/greece.png", null));
    }
}
