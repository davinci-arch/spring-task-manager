package com.example.spring_task_manager.controller;

import com.example.spring_task_manager.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return List.of();
    }
    @PostMapping
    public ResponseEntity<UserDTO> createNewUser(@RequestBody UserDTO user) {
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return null;
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user, @PathVariable Long id) {
        return null;
    }
}
