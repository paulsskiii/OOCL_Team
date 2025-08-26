package com.example.day12;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> { //Long - taskNumbers
    //By extending JPARepository, we get all the common CRUD methods for out Task entity for free
}