package com.example.day12;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // extending JpaRepository, we get all common CRUD (Create, Read, Update, Delete) methods for Task entity for free/automatically
}
