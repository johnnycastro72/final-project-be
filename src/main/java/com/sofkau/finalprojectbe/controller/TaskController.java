package com.sofkau.finalprojectbe.controller;

import com.sofkau.finalprojectbe.entity.Category;
import com.sofkau.finalprojectbe.entity.Task;
import com.sofkau.finalprojectbe.service.CategoryService;
import com.sofkau.finalprojectbe.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TaskService taskService;

    @GetMapping("get/tasks")
    public List<Task> getAllTaskByCategory(@RequestBody Category category){
        return taskService.findAllTasksByCategory(category);
    }

    @PostMapping("save/task")
    public Category createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping("update/task")
    public Category updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("delete/task")
    public void deleteTask(@RequestBody Task task) {
        taskService.deleteTask(task.getId());
    }
}
