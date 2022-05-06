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
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Task> findAllTasksByCategory(Category category) {

        Category categoryFilter = categoryRepository.findById(category.getId()).orElse(null);

        if (categoryFilter == null) {
            throw new CategoryNotFoundException("Category not found in the list of tasks filtered by category " +
                    category.getId());
        }

        List<Task> tasks = taskRepository.findAllByCategory(category);

        return tasks;
    }

    @Override
    public Category saveTask(Task task) {
        Category categoryFilter = categoryRepository.findById(task.getCategory().getId()).orElse(null);

        if (categoryFilter == null) {
            throw new CategoryNotFoundException("Category not found while adding the task " + task.getId());
        }

        Category category = categoryRepository.findById(task.getCategory().getId()).get();
        category.addTask(task);
        categoryRepository.save(category);

        return category;
    }

    @Override
    public Category updateTask(Task task) {
        Task taskFilter = taskRepository.findById(task.getId()).orElse(null);
        Task taskToBeUpdated = taskRepository.findById(task.getId()).get();
        Category category = taskToBeUpdated.getCategory();
        Category categoryFilter = categoryRepository.findById(category.getId()).orElse(null);

        if (categoryFilter == null) {
            throw new CategoryNotFoundException("Category not found when trying to update task. Task id: " + task.getId());
        }
        if (taskFilter == null) {
            throw new TaskNotFoundException("Task not found when trying to delete it. Task id: " + task.getId());
        }

        taskToBeUpdated.setMessage(task.getMessage());
        taskToBeUpdated.setDone(task.getDone());
        taskRepository.save(taskToBeUpdated);

        return categoryRepository.save(category);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null) {
            throw new TaskNotFoundException("Task not found when trying to delete it. Task id: " + id);
        }

        taskRepository.deleteById(id);
    }
}
