package com.sofkau.finalprojectbe.converters;

import com.sofkau.finalprojectbe.dto.CategoryDto;
import com.sofkau.finalprojectbe.dto.TaskDto;
import com.sofkau.finalprojectbe.entity.Category;
import com.sofkau.finalprojectbe.entity.Task;
import org.modelmapper.ModelMapper;

public class SingleModelMapper {

    private final ModelMapper singleMapper = new ModelMapper();

    public Task mapToTask(TaskDto taskDto){
        return singleMapper.map(taskDto, Task.class);
    }

    public Category mapToCategory(CategoryDto categoryDto) {
        return singleMapper.map(categoryDto, Category.class);
    }

    public TaskDto mapToTaskDto(Task task) {
        return singleMapper.map(task, TaskDto.class);
    }

    public CategoryDto mapToCategoryDto(Category category) {
        return singleMapper.map(category, CategoryDto.class);
    }
}
