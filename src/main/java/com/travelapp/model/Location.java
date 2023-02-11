package com.travelapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


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

  public Location() {

  }
  public Location(String name, String address,String description, String source, String imageUrl,String longitude, String latitude) {
    this.name = name;
    this.address = address;
    this.description=description;
    this.source = source;
    this.imageUrl=imageUrl;
    this.longitude = longitude;
    this.latitude = latitude;
  }

}
