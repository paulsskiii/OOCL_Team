package com.example.day12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //Combines @Controller and @ResponseBody to make this class a REST Controller
@RequestMapping("/api/tasks") // Maps all the methods in this controller to the /api/tasks endpoint
public class TaskController {
    @Autowired // Spring automatically provides an instance of TaskRepository
    private TaskRepository taskRepository;

    @GetMapping //SELECT
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping //CREATE
    public Task addTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")//DELETE
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}