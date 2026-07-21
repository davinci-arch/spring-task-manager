package com.example.spring_task_manager.dto;

import com.example.spring_task_manager.entity.AssignedUser;
import com.example.spring_task_manager.entity.Priority;
import com.example.spring_task_manager.entity.Status;
import com.example.spring_task_manager.entity.Task;

import java.time.LocalDateTime;

public record TaskDTO(String title,
                      String description,
                      Status status,
                      LocalDateTime deadLine,
                      Long userId,
                      Priority priority
                      ) {

    public static TaskDTO from(Task task) {
        return new TaskDTO(task.getTitle(), task.getDescription(), task.getStatus(),
                task.getDeadLine(), task.getAssignedUser().getId(), task.getPriority());
    }
}
