package com.sofkau.finalprojectbe.repository;

import com.sofkau.finalprojectbe.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}