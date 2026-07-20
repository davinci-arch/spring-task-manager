package com.example.spring_task_manager.exceptions;

public class ProjectDoNotExist extends RuntimeException {
    public ProjectDoNotExist(String message) {
        super(message);
    }
}
