package com.sofkau.finalprojectbe.controller;

import com.sofkau.finalprojectbe.converters.SingleModelMapper;
import com.sofkau.finalprojectbe.dto.CategoryDto;
import com.sofkau.finalprojectbe.dto.TaskDto;
import com.sofkau.finalprojectbe.service.CategoryService;
import com.sofkau.finalprojectbe.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private SingleModelMapper singleMapper;

    @GetMapping("get/tasks")
    public List<TaskDto> getAllTaskByCategory(@RequestBody CategoryDto categoryDto) {

        return taskService.findAllTasksByCategory(
                singleMapper.mapToCategory(categoryDto)).stream().map(
                task -> singleMapper.mapToTaskDto(task)
        ).collect(Collectors.toUnmodifiableList());
    }

    @PostMapping("save/task")
    public CategoryDto createTask(@RequestBody TaskDto taskDto) {
        return singleMapper.mapToCategoryDto(taskService.saveTask(singleMapper.mapToTask(taskDto)));
    }

    @PutMapping("update/task")
    public CategoryDto updateTask(@RequestBody TaskDto taskDto) {
        return singleMapper.mapToCategoryDto(taskService.updateTask(singleMapper.mapToTask(taskDto)));
    }

    @DeleteMapping("delete/task")
    public void deleteTask(@RequestBody TaskDto taskDto) {
        taskService.deleteTask(singleMapper.mapToTask(taskDto).getId());
    }
}
