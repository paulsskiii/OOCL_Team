package com.example.pair_prog.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.pair_prog.model.Task;
import com.example.pair_prog.repository.TaskRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tasks")

public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
        public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    // http://localhost:8080/api/tasks/findtitle?title=build
    @GetMapping("/findtitle")
    public List<Task> findByTitle(@RequestParam String title){
        return taskRepository.findByTitleLike(title);
    }

    // localhost:8080/api/tasks/filter?completed=false
    @GetMapping("/filter")
    public List<Task> filterByCompleted(@RequestParam boolean completed) {
        return taskRepository.filterByCompleted(completed);
    }

    // http://localhost:8080/api/tasks/findfilter?title=build&complete=true
    @GetMapping("/findfilter")
    public List<Task> findAndFilterByCompleted(@RequestParam String title, @RequestParam boolean completed) {
            return taskRepository.findAndFilterByCompleted(title, completed);
    }
}