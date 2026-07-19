package com.example.spring_task_manager.dto;

import com.example.spring_task_manager.entity.AssignedUser;
import com.example.spring_task_manager.entity.Status;

public record TaskDTO(String title,
                      String description,
                      Status status,
                      AssignedUser user) {
}
