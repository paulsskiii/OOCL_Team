package com.example.pair_prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pair_prog.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
