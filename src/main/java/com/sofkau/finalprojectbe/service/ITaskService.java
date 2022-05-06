package com.sofkau.finalprojectbe.service;

import com.sofkau.finalprojectbe.entity.Category;
import com.sofkau.finalprojectbe.entity.Task;

import java.util.List;

public interface ITaskService {

    List<Task> findAllTasksByCategory(Category category);

    Task saveTask(Task task);

    Task updateTask(Task task);

    void deleteTask(Long id);
}
