package com.example.pair_prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pair_prog.model.Task;
import java.util.List;
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

    @Query(value = "SELECT * FROM TASK WHERE completed = :completed AND title LIKE CONCAT('%', :title, '%')", nativeQuery = true)
    List<Task> findAndFilterByCompleted(@Param("title") String title, @Param("completed") boolean completed);
}
