package com.pairprog.pairprog.repository;

import com.pairprog.pairprog.model.Task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT * FROM TASK WHERE title LIKE CONCAT('%', :title, '%')", nativeQuery = true)
    // @Query(value = "SELECT * FROM TASK WHERE title like '%:title%'", nativeQuery = true)
    List<Task> findByTitleLike(@Param("title") String title);
    
    @Query(value = "SELECT * FROM TASK WHERE completed = :completed", nativeQuery = true)
    List<Task> filterByCompleted(@Param("completed") boolean completed);
}
