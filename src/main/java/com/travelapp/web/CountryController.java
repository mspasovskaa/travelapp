package com.travelapp.web;

import com.travelapp.model.Country;
import com.travelapp.service.CountryService;
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

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    public String getMainPage(Model model) {
        List<Country> countries = this.countryService.listCountries();
        model.addAttribute("countries", countries);
        return "home";
    }

    @GetMapping("/countries")
    public String getCountries(Model model){
        List<Country> countries = this.countryService.listCountries();
        model.addAttribute("countries", countries);
        return "countryList";
    }
}
