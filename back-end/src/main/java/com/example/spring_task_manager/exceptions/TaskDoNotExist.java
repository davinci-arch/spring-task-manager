package com.example.spring_task_manager.exceptions;

public class TaskDoNotExist extends RuntimeException {
    public TaskDoNotExist(String message) {
        super(message);
    }
}
