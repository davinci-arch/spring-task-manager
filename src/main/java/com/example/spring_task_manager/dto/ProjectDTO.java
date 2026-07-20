package com.example.spring_task_manager.dto;

import com.example.spring_task_manager.entity.Task;
import org.apache.catalina.User;

import java.util.List;

public record ProjectDTO(String name, String description, List<User> users, List<Task> tasks) {}
