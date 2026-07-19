package com.example.spring_task_manager.exceptions;

public class TaskAlreadyExists extends RuntimeException {
    public TaskAlreadyExists(String message) {
        super(message);
    }
}
