package com.travelapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
  @ManyToMany
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
