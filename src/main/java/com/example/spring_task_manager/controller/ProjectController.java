package com.example.spring_task_manager.controller;

import com.example.spring_task_manager.dto.ProjectDTO;
import com.example.spring_task_manager.entity.AssignedUser;
import com.example.spring_task_manager.entity.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return null;
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createNewProject(@RequestBody ProjectDTO projectDTO) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProjectDTO> deleteProject(@PathVariable Long id) {
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProjectDescription(@PathVariable Long id, @RequestBody String description) {
        return null;
    }

    @PatchMapping("/{id}/users")
    public ResponseEntity<ProjectDTO> addNewUser(@PathVariable Long id, @RequestBody AssignedUser user) {
        return null;
    }

    @PatchMapping("/{id}/tasks")
    public ResponseEntity<Task> addNewTask(@PathVariable Long id, @RequestBody Task task) {
        return null;
    }
}
