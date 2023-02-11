package com.travelapp.model;

import jakarta.persistence.*;

import java.util.List;
import lombok.Data;

@Data
@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  public String name;
  public String imageUrl;
  @ManyToMany(cascade = CascadeType.ALL)
  public List<Location> locationList;

  public Category(){}
  public Category(String name,String imageUrl) {
    this.name = name;
    this.imageUrl=imageUrl;
  }

  public Category(String name, String imageUrl, List<Location> locationList) {
    this.name = name;
    this.imageUrl=imageUrl;
    this.locationList = locationList;
  }
}
