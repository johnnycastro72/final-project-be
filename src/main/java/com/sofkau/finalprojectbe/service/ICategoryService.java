package com.sofkau.finalprojectbe.service;

import com.sofkau.finalprojectbe.entity.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAllCategories();

    Category saveCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Category category);
}
