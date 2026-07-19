package com.example.spring_task_manager.exceptions;

public class UserAlreadyExistsInDataBase extends RuntimeException {
    public UserAlreadyExistsInDataBase(String message) {
        super(message);
    }

}
