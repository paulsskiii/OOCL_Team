package com.example.pomdoro;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTitleOrDescriptionIgnoreCase();
    List<Task> findByStatusTrue();
    List<Task> findByStatusFalse();
}