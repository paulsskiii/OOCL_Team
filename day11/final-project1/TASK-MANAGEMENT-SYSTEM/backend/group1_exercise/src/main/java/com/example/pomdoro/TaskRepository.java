package com.example.pomdoro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTitleContainingOrDescriptionContainingIgnoreCase(String title, String description);

    List<Task> findByCompletedTrue();

    List<Task> findByCompletedFalse();
}
