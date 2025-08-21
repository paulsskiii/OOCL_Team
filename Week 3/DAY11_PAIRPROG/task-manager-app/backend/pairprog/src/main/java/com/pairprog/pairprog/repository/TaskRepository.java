package com.pairprog.pairprog.repository;

import com.pairprog.pairprog.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
