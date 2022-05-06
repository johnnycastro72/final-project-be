package com.sofkau.finalprojectbe.service;

import com.sofkau.finalprojectbe.entity.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAllCategories();

    Category saveCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Long id);
}
