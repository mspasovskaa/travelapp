package com.travelapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String mapUrl;
    @OneToMany
    private List<Location> locations;

    public Country() {
    }

    public Country(String name, String description, String imageUrl, String mapUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.mapUrl = mapUrl;
    }
}
