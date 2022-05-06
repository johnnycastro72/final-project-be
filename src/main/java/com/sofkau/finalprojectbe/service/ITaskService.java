package com.sofkau.finalprojectbe.service;

import com.sofkau.finalprojectbe.entity.Category;
import com.sofkau.finalprojectbe.entity.Task;

import java.util.List;

public interface ITaskService {

    List<Task> findAllTasksByCategory(Category category);

    Category saveTask(Task task);

    Category updateTask(Task task);

    void deleteTask(Long id);
}
