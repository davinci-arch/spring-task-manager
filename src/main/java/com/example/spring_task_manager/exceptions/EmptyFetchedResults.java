package com.example.spring_task_manager.exceptions;

public class EmptyFetchedResults extends RuntimeException {
    public EmptyFetchedResults(String noProjectsPresent) {
    }
}
