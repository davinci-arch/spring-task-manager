package com.example.spring_task_manager.dto;

import com.example.spring_task_manager.entity.Position;

public record UserDTO(String firstName, String email, Position position){};
