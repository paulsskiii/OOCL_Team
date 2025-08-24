package com.example.day12;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    /*
     * By extending JpaRepository, we get all the common CRUD methods for our Task entity for free.
     */
}
