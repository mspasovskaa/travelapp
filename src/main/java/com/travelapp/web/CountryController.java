package com.travelapp.web;

import com.travelapp.model.Country;
import com.travelapp.model.Location;
import com.travelapp.service.CountryService;
import com.travelapp.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CountryController {
    private final CountryService countryService;
    private final LocationService locationService;

    public CountryController(CountryService countryService, LocationService locationService) {
        this.countryService = countryService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getMainPage(Model model) {
        List<Country> countries = this.countryService.listCountries();
        model.addAttribute("countries", countries);
        return "home";
    }

    @GetMapping("/countries/{id}")
    public String getCountry(@PathVariable Long id, Model model) {
        Country country = this.countryService.findById(id);
        List<Location> locations = this.locationService.filterByCategoryAndCountry(id, null);
        model.addAttribute("country",country);
        model.addAttribute("locations",locations);
        return "country";
    }
}
