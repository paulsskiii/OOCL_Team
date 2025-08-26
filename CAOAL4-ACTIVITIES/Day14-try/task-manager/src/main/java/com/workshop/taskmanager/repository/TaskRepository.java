package com.workshop.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workshop.taskmanager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.completed = :status ORDER BY t.createdAt DESC")
    List<Task> findByCompletedOrderByCreatedAtDesc(Boolean completed);
}
