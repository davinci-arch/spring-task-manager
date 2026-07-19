package com.example.spring_task_manager.controller;

import com.example.spring_task_manager.entity.Status;
import com.example.spring_task_manager.entity.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    @GetMapping
    public List<Task> getAllTasks() {
        return List.of();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Task> createTask(@PathVariable Long id, @RequestBody Task task) {
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestBody Status status) {
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateTaskDescription(@PathVariable Long id, @RequestBody String description) {
        return null;
    }

}
