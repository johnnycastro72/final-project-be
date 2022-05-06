package com.sofkau.finalprojectbe.repository;

import com.sofkau.finalprojectbe.entity.Category;
import com.sofkau.finalprojectbe.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByCategory(Category category);
}