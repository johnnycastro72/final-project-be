package com.sofkau.finalprojectbe.service;

import com.sofkau.finalprojectbe.entity.Category;
import com.sofkau.finalprojectbe.entity.Task;
import com.sofkau.finalprojectbe.exceptions.CategoryNotFoundException;
import com.sofkau.finalprojectbe.exceptions.TaskNotFoundException;
import com.sofkau.finalprojectbe.repository.CategoryRepository;
import com.sofkau.finalprojectbe.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;
    private CategoryRepository categoryRepository;

    @Override
    public List<Task> getAllTasksByCategory(Category category) {

        Category categoryFilter = categoryRepository.findById(category.getId()).orElse(null);

        if (categoryFilter == null) {
            throw new CategoryNotFoundException("Category not found in the list of tasks filtered by category " +
                    category.getId());
        }

        List<Task> tasks = taskRepository.findAllByCategory(category);

        return tasks;
    }

    @Override
    public Task saveTask(Task task) {
        Category categoryFilter = categoryRepository.findById(task.getCategory().getId()).orElse(null);

        if (categoryFilter == null) {
            throw new CategoryNotFoundException("Category not found while adding the task " + task.getId());
        }
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null) {
            throw new TaskNotFoundException("Task not found while deleting it " + task.getId());
        }
    }
}
