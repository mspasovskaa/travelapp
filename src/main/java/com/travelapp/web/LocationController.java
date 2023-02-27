package com.travelapp.web;

import com.travelapp.model.Category;
import com.travelapp.model.Country;
import com.travelapp.model.Location;
import com.travelapp.service.CategoryService;
import com.travelapp.service.CountryService;
import com.travelapp.service.LocationService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/locations")
public class LocationController {
  private final LocationService locationService;
  private final CategoryService categoryService;
  private final CountryService countryService;

  public LocationController(LocationService locationService, CategoryService categoryService, CountryService countryService) {
    this.locationService = locationService;
    this.categoryService = categoryService;
    this.countryService = countryService;
  }

  @GetMapping
  public String getLocations(@RequestParam(required = false) Long categoryId,
                             @RequestParam(required = false) Long countryId, Model model) {
    List<Location> locations;
    Country country;
    Category category;
    if(categoryId!=null && countryId!=null){
      locations = this.locationService.filterByCategoryAndCountry(countryId, categoryId);
      country = this.countryService.findById(countryId);
      category = this.categoryService.findById(categoryId);
    }
    else if(categoryId!=null){
      locations = this.locationService.filterByCategoryAndCountry(countryId, categoryId);
      category = this.categoryService.findById(categoryId);
      country = null;
    }
    else if(countryId!=null){
      locations = this.locationService.filterByCategoryAndCountry(countryId, categoryId);
      country = this.countryService.findById(countryId);
      category = null;
    }
    else{
      locations = this.locationService.listLocations();
      country = null;
      category = null;
    }

    List<Category> categories = categoryService.listCategories();
    List<Country> countries = countryService.listCountries();

    model.addAttribute("locations", locations);
    model.addAttribute("categories", categories);
    model.addAttribute("countries", countries);
    model.addAttribute("selectedCountry", country);
    model.addAttribute("selectedCategory", category);
    return "locations";
  }

  @GetMapping("/map")
  public String getMap(Model model) {
    return "map";
  }

  @GetMapping("/{id}")
  public String getLocation(@PathVariable Long id, Model model) {
    Location location = locationService.findById(id);
    model.addAttribute("location",location);

    List<Category> categories = location.getCategories();
    model.addAttribute("categories", categories);

    Country country = location.getCountry();
    model.addAttribute("country", country);
    return "location";
  }
}
