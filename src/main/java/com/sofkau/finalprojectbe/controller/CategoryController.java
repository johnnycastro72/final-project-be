package com.sofkau.finalprojectbe.controller;

import com.sofkau.finalprojectbe.entity.Category;
import com.sofkau.finalprojectbe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAllCategories();
    }

    @PostMapping("save/category")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("update/category")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("delete/category")
    public void deleteCategory(@RequestBody Category category) {
        categoryService.deleteCategory(category);
    }
}
