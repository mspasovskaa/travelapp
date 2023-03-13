package com.travelapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String email;
    private String password;
    private String name;
    private String surname;
    @ManyToMany
    private List<Location> favoriteLocations;

    public User() {
    }

    public User(String username, String email, String password, String name, String surname) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
