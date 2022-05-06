package com.sofkau.finalprojectbe.service;

import com.sofkau.finalprojectbe.entity.Category;
import com.sofkau.finalprojectbe.exceptions.CategoryNotFoundException;
import com.sofkau.finalprojectbe.repository.CategoryRepository;
import com.sofkau.finalprojectbe.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Category> findAllCategories() {

        return categoryRepository.findAll();

    }

    @Override
    public Category saveCategory(Category category) {
        if (category.getTitle().isBlank()) {
            throw new CategoryNotFoundException("Category title can't be blank");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Category categoryToBeDeleted = categoryRepository.findById(category.getId()).orElse(null);

        if (categoryToBeDeleted == null) {
            throw new CategoryNotFoundException("Category not found when trying to update it. Category Id: " + category.getId());
        }

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        Category categoryToBeDeleted = categoryRepository.findById(category.getId()).get();

        if (categoryToBeDeleted.getId() != category.getId()) {
            throw new CategoryNotFoundException("Category not found when trying to delete it. Category id: " + category.getId());
        }
        if (!categoryToBeDeleted.getTasks().isEmpty()) {
            categoryToBeDeleted.getTasks().forEach(
                    task -> taskRepository.deleteById(task.getId()));
        }

        categoryRepository.deleteById(category.getId());
    }
}
