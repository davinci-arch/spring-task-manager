package com.example.spring_task_manager.service;

import com.example.spring_task_manager.entity.Project;
import com.example.spring_task_manager.entity.Task;
import com.example.spring_task_manager.exceptions.EmptyFetchedResults;
import com.example.spring_task_manager.exceptions.ProjectAlreadyExists;
import com.example.spring_task_manager.exceptions.ProjectDoNotExist;
import com.example.spring_task_manager.repository.ProjectRepository;
import com.example.spring_task_manager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private UserRepository userRepository;
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        if (projectRepository.existsByName(project.getName())) {
            throw new ProjectAlreadyExists(
                    String.format("Project with that title \"%s\" already exists", project.getName()));
        }
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        var projects = projectRepository.findAll();
        if (projects.isEmpty()) {
            throw new EmptyFetchedResults("No projects present");
        }
        return projectRepository.findAll();
    }

    public Project getProjectByName(String projectName) {
        return projectRepository.findByName(projectName).orElseThrow();
    }

    public void deleteProjectByName(String projectName) {
        if (!projectRepository.existsByName(projectName)) {
            throw new ProjectDoNotExist(
                    String.format("Project with that name \"%s\" does not exist", projectName));
        }
    }

    public void addNewTask(Long id, Task task) {
        var project = projectRepository.findById(id).orElseThrow();
        project.getTasks().add(task);

        projectRepository.save(project);
    }
    public void assignUserToProject(Long projectId, Long userId) {
        var project = projectRepository.findById(projectId).orElseThrow();
        var user = userRepository.findById(userId).orElseThrow();

        if (!project.getAssignedUsers().contains(user)) {
            project.assignUser(user);
        }
        projectRepository.save(project);
    }

    public Project changeDescription(Long projectId, String description) {
        var project = projectRepository.findById(projectId).orElseThrow();
        project.setDescription(description);

        return projectRepository.save(project);
    }

}
