package com.travelapp.service;

import com.travelapp.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> findByName(String name);
    List<Category> listCategories();
}
