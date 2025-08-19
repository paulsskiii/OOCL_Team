package com.example.day12;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping ("/api/tasks")
public class TaskController {
    @Autowired  //Spring automatically provides an instance of TaskRepository
    private TaskRepository taskRepository;

    // Following annotations map methods to specific HTTP verbs
    @GetMapping
    public List<Task> getAllTasks () {
        return taskRepository.findAll ();
    }

    @PostMapping
    public Task addTasks (@RequestBody Task task) {
        return taskRepository.save (task);
    }

    @DeleteMapping ("/{id}")
    public void deleteTask (@PathVariable Long id) {
        taskRepository.deleteById (id);
    }
}
