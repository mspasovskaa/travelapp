package com.travelapp.web;

import com.travelapp.model.Location;
import com.travelapp.service.LocationService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/locations")
public class LocationController {
  private final LocationService locationService;

  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }

  @GetMapping()
  public String getLocations(@RequestParam(required = false) Long categoryId,
                             @RequestParam(required = false) Long countryId, Model model) {
    List<Location> locations;
    if(categoryId==null && countryId==null)
      locations = this.locationService.listLocations();
    else
      locations = this.locationService.filterByCategoryAndCountry(categoryId, countryId);

    model.addAttribute("locations",locations);
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
    return "location";
  }
}
