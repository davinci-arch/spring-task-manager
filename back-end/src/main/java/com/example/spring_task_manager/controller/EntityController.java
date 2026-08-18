package com.example.spring_task_manager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/available-tables")
public class EntityController {

    @GetMapping
    public ResponseEntity<List<String>> getLoadedTableNames() {
        return ResponseEntity.ok()
                .body(List.of(
                        "Projects",
                        "Users",
                        "Tasks"
                ));
    }
}
