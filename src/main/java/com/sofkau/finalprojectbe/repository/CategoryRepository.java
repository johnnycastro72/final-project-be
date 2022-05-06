package com.sofkau.finalprojectbe.repository;

import com.sofkau.finalprojectbe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}