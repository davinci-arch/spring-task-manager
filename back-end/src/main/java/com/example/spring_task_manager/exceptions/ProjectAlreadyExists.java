package com.example.spring_task_manager.exceptions;

public class ProjectAlreadyExists extends RuntimeException {
    public ProjectAlreadyExists(String message) {
        super(message);
    }
}
