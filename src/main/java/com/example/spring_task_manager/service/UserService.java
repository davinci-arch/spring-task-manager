package com.example.spring_task_manager.service;

import com.example.spring_task_manager.entity.AssignedUser;
import com.example.spring_task_manager.exceptions.UserAlreadyExistsInDataBase;
import com.example.spring_task_manager.exceptions.UserNotFoundException;
import com.example.spring_task_manager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<AssignedUser> getAllUsers() {
        return userRepository.findAll();
    }
    public AssignedUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(
                    "User not found"
            );
        }
        userRepository.deleteById(id);
    }
    public AssignedUser createUser(AssignedUser assignedUser) {
        if (userRepository.existsByEmail(assignedUser.getEmail())) {
            throw new UserAlreadyExistsInDataBase(
                    String.format("User with this email {%s} already exists in database.",
                            assignedUser.getEmail()));
        }
        return userRepository.save(assignedUser);
    }
    public AssignedUser updateUser(AssignedUser assignedUser) {
        var entityFromDB = getUserById(assignedUser.getId());

        entityFromDB.setEmail(assignedUser.getEmail());
        entityFromDB.setFirstName(assignedUser.getFirstName());
        entityFromDB.setPosition(assignedUser.getPosition());

        return userRepository.save(entityFromDB);
    }
}
