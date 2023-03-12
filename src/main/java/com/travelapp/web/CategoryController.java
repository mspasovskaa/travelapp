package com.travelapp.web;

import org.springframework.ui.Model;
import com.travelapp.model.Category;
import com.travelapp.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getCategories(Model model) {
        List<Category> categoryList = this.categoryService.listCategories();
        model.addAttribute("categories", categoryList);
        return "categoryList";
    }

    @GetMapping("/{categoryId}")
    public String getCategory(@PathVariable Long categoryId,Model model) {
        Category category = this.categoryService.findById(categoryId);
        model.addAttribute("category", category);
        return "category";
    }
}
