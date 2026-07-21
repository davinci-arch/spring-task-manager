package com.example.spring_task_manager.controller;

import com.example.spring_task_manager.dto.ProjectDTO;
import com.example.spring_task_manager.entity.AssignedUser;
import com.example.spring_task_manager.entity.Task;
import com.example.spring_task_manager.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects()
                .stream()
                .map(ProjectDTO::from)
                .toList();
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createNewProject(@RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectService.createProject(projectDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id, @RequestParam("projectTitle") String projectTitle) {
        projectService.deleteProjectByName(projectTitle);
        return ResponseEntity.ok(String.format("Project with title:%s was deleted", projectTitle));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProjectDescription(@PathVariable Long id, @RequestBody String description) {
        return ResponseEntity.ok(projectService.changeDescription(id, description));
    }

    @PatchMapping("/{id}/users")
    public ResponseEntity<String> addNewUser(@PathVariable Long id, @RequestBody AssignedUser user) {
        projectService.assignUserToProject(id, user.getId());
        return ResponseEntity.ok(String.format("User with id:%d was assigned to project succsessfully", id));
    }

    @PatchMapping("/{id}/tasks")
    public ResponseEntity<String> addNewTask(@PathVariable Long id, @RequestBody Task task) {
        projectService.addNewTask(id, task);
        return ResponseEntity.ok(String.format("New task with title:%s to proejct was added", task.getTitle()));
    }
}
