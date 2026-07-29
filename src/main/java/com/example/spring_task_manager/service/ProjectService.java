package com.example.spring_task_manager.service;

import com.example.spring_task_manager.dto.ProjectDTO;
import com.example.spring_task_manager.dto.ProjectDTOCreateRequest;
import com.example.spring_task_manager.entity.Project;
import com.example.spring_task_manager.entity.Task;
import com.example.spring_task_manager.exceptions.EmptyFetchedResults;
import com.example.spring_task_manager.exceptions.ProjectAlreadyExists;
import com.example.spring_task_manager.exceptions.ProjectDoNotExist;
import com.example.spring_task_manager.repository.ProjectRepository;
import com.example.spring_task_manager.repository.TaskRepository;
import com.example.spring_task_manager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public ProjectDTO createProject(ProjectDTOCreateRequest project) {
        if (projectRepository.existsByName(project.title())) {
            throw new ProjectAlreadyExists(
                    String.format("Project with that title \"%s\" already exists", project.title()));
        }
        var newProject = new Project(project.title(), project.description());
        return ProjectDTO.from(projectRepository.save(newProject));
    }

    public void createAllProjects(List<ProjectDTOCreateRequest> projects) {
        projects.forEach(this::createProject);
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

    public void addNewTask(Long id, Long taskId) {
        var project = projectRepository.findById(id).orElseThrow();
        var task = taskRepository.findById(taskId).orElseThrow();
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

    public ProjectDTO changeDescription(Long projectId, String description) {
        var project = projectRepository.findById(projectId).orElseThrow();
        project.setDescription(description);

        return ProjectDTO.from(projectRepository.save(project));
    }

}
