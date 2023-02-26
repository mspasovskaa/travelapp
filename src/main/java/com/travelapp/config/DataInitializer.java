package com.travelapp.config;

import com.travelapp.model.Category;
import com.travelapp.model.Country;
import com.travelapp.model.Location;
import com.travelapp.repository.CategoryRepository;
import com.travelapp.repository.CountryRepository;
import com.travelapp.repository.LocationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        Category beach = new Category("Beach", "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/beach-quotes-1559667853.jpg");
        Category camping = new Category("Camping", "https://www.rei.com/dam/skrobecki_071217_1458_tents_camping_choose_tents_for_camping_choose_lg.jpg");
        categoryRepository.save(beach);
        categoryRepository.save(camping);

        List<Category> beachCamping = categoryRepository.findAll();
        beachCamping.add(beach);
        beachCamping.add(camping);

        Country Macedonia = new Country("Macedonia", "MK Desc", "https://i.ibb.co/60zNZds/Macedonia.png", null);
        countryRepository.save(Macedonia);
        locationRepository.save(new Location("Gradiste Beach", "Gradiste, Ohrid", "Beach with clean waters and beautiful nature", null, "https://i1.wp.com/www.discoveringmacedonia.com/wp-content/uploads/2019/04/ohrid-beaches.jpg?fit=2048%2C1536&ssl=1", "20.8095906467","41.1196629179", Macedonia, beachCamping));
        locationRepository.save(new Location("Slavija Beach", "Sveti Stefan, Ohrid", "Great beach in Ohrid", null, "https://mymacedoniablog.files.wordpress.com/2018/04/img_1311-ohrid-quiet-beach.jpg?w=900", null,null, Macedonia, beachCamping));

        Country Serbia = new Country("Serbia", "SRB Desc", "https://i.ibb.co/rfFCfwv/Serbia.png", null);
        countryRepository.save(Serbia);

        Country Greece = new Country("Greece", "GR Desc", "https://i.ibb.co/vw0CP2j/greece.png", null);
        countryRepository.save(Greece);
    }
}
