package com.example.spring_task_manager.repository;

import com.example.spring_task_manager.entity.AssignedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AssignedUser, Long> {

    boolean existsByEmail(String email);
}
