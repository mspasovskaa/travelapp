package com.travelapp.service.impl;

import com.travelapp.model.Category;
import com.travelapp.repository.CategoryRepository;
import com.travelapp.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> findByName(String name) {
        return this.categoryRepository.findByName(name);
    }

    @Override
    public List<Category> listCategories() {
        return this.categoryRepository.findAll();
    }
}
