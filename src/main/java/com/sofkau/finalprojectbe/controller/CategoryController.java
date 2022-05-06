package com.sofkau.finalprojectbe.controller;

import com.sofkau.finalprojectbe.converters.SingleModelMapper;
import com.sofkau.finalprojectbe.dto.CategoryDto;
import com.sofkau.finalprojectbe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SingleModelMapper singleMapper;

    @GetMapping
    public List<CategoryDto> getAllCategories() {

        return categoryService.findAllCategories().stream().map(
                category -> singleMapper.mapToCategoryDto(category)
        ).collect(Collectors.toUnmodifiableList());
    }

    @PostMapping("save/category")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {

        return singleMapper.mapToCategoryDto(categoryService.saveCategory(
                singleMapper.mapToCategory(categoryDto)));
    }

    @PutMapping("update/category")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto) {

        return singleMapper.mapToCategoryDto(categoryService.updateCategory(
                singleMapper.mapToCategory(categoryDto)));
    }

    @DeleteMapping("delete/category")
    public void deleteCategory(@RequestBody CategoryDto categoryDto) {

        categoryService.deleteCategory(singleMapper.mapToCategory(categoryDto));
    }
}
