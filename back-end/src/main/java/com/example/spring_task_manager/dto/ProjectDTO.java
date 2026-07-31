package com.example.spring_task_manager.dto;

import com.example.spring_task_manager.entity.AssignedUser;
import com.example.spring_task_manager.entity.Project;
import com.example.spring_task_manager.entity.Task;

import java.util.List;

public record ProjectDTO(String name, String description) {

    public static ProjectDTO from(Project project) {
        return new ProjectDTO(project.getName(), project.getDescription());
    }

}
