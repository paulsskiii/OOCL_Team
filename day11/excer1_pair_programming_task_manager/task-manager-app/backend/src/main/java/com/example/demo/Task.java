package com.example.demo;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "title")
private String title;
@Column(name = "description")
private String description;
@Column(name = "completed")
private boolean completed;
// Constructors
public Task() {}
public Task(String title, String description) {
this.title = title;
this.description = description;
this.completed = false;
}
// Getters and Setters

public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getTitle() { return title; }
public void setTitle(String title) { this.title = title; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
public boolean isCompleted() { return completed; }
public void setCompleted(boolean completed) { this.completed = completed; }
}