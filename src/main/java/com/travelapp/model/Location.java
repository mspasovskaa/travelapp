package com.travelapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  public String name;

  public String address;

  public String description;

  public String source;

  public String imageUrl;

  public String longitude;

  public String latitude;

  @ManyToMany(cascade = CascadeType.ALL)
  private List<Category> categories;
  @ManyToOne
  private Country country;

  public Location() {

  }
  public Location(String name, String address,String description, String source, String imageUrl,String longitude, String latitude, Country country, List<Category> categories) {
    this.name = name;
    this.address = address;
    this.description=description;
    this.source = source;
    this.imageUrl=imageUrl;
    this.longitude = longitude;
    this.latitude = latitude;
    this.country = country;
    this.categories = categories;
  }

}
