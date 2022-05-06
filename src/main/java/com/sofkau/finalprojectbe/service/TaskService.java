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
    public Task saveTask(Task task) {
        Category categoryFilter = categoryRepository.findById(task.getCategory().getId()).orElse(null);

        if (categoryFilter == null) {
            throw new CategoryNotFoundException("Category not found while adding the task " + task.getId());
        }
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        Task taskToBeUpdated = taskRepository.findById(task.getId()).orElse(null);
        Category categoryFilter = categoryRepository.findById(task.getCategory().getId()).orElse(null);

        if (categoryFilter == null) {
            throw new CategoryNotFoundException("Category not found when trying to update task. Task id: " + task.getId());
        }
        if (taskToBeUpdated == null) {
            throw new TaskNotFoundException("Task not found when trying to delete it. Task id: " + task.getId());
        }

        return taskRepository.save(task);
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
