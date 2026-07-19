package com.example.spring_task_manager.service;

import com.example.spring_task_manager.entity.Status;
import com.example.spring_task_manager.entity.Task;
import com.example.spring_task_manager.exceptions.TaskAlreadyExists;
import com.example.spring_task_manager.exceptions.TaskDoNotExist;
import com.example.spring_task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        if(taskRepository.existsByTitle(task.getTitle())) {
           throw
                   new TaskAlreadyExists(
                           String.format("Task with that title \"%s\" already exists", task.getTitle()));
        }
        return taskRepository.save(task);
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }
    public void updateTaskStatus(Long id, Status status) {
        var existedTask = getTaskById(id);
        existedTask.setStatus(status);

        taskRepository.save(existedTask);
    }
    public void updateTaskDescription(Long id, String description) {
        var existedTask = getTaskById(id);
        existedTask.setDescription(description);

        taskRepository.save(existedTask);
    }
    public void deleteTaskById(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskDoNotExist(
                    String.format("Task with id \"%d\" does not exist", id)
            );
        }
        taskRepository.deleteById(id);
    }
}
