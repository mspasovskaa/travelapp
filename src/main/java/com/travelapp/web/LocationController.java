package com.travelapp.web;

import com.travelapp.model.Location;
import com.travelapp.service.LocationService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/locations")
public class LocationController {
  private final LocationService locationService;

  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }
  @GetMapping("/map")
  public String getMap(Model model) {
    return "map";
  }
  @PostMapping("/{id}")
  public String getLocation(@PathVariable Long id, Model model) {
    Location location = locationService.findById(id);
    model.addAttribute("location",location);
    return "location";
  }

  @PostMapping("/findAllByCategory/{categoryId}")
  public String getLocationsByCategoryId(@PathVariable Long categoryId, Model model) {
    List<Location> locations = locationService.listLocationsByCategory(categoryId);
    model.addAttribute("locations",locations);
    return "locations";
  }
}
