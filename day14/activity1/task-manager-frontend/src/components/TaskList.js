import React, { useState, useEffect } from "react";
import { taskService } from "../services/taskService";
import TaskItem from "./TaskItem";
import TaskForm from "./TaskForm";

const TaskList = () => {
  const [tasks, setTasks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    loadTasks();
  }, []);

  const loadTasks = async () => {
    try {
      setLoading(true);
      const response = await taskService.getAllTasks();
      setTasks(response.data);
    } catch (err) {
      setError("Failed to load tasks");
    } finally {
      setLoading(false);
    }
  };

  const handleCreateTask = async (taskData) => {
    try {
      await taskService.createTask(taskData);
      loadTasks();
    } catch (err) {
      setError("Failed to create task");
    }
  };

  const handleToggleTask = async (id, completed) => {
    try {
      const task = tasks.find((t) => t.id === id);
      await taskService.updateTask(id, { ...task, completed });
      loadTasks();
    } catch (err) {
      setError("Failed to update task");
    }
  };

  const handleDeleteTask = async (id) => {
    try {
      await taskService.deleteTask(id);
      loadTasks();
    } catch (err) {
      setError("Failed to delete task");
    }
  };

  if (loading) return <div className="loading">Loading...</div>;
  if (error) return <div className="error">{error}</div>;

  return (
    <div className="task-list-container">
      <TaskForm onSubmit={handleCreateTask} />
      <div className="tasks">
        <h2>Tasks ({tasks.length})</h2>
        {tasks.length === 0 ? (
          <p>No tasks yet. Create your first task!</p>
        ) : (
          tasks.map((task) => (
            <TaskItem
              key={task.id}
              task={task}
              onToggle={handleToggleTask}
              onDelete={handleDeleteTask}
            />
          ))
        )}
      </div>
    </div>
  );
};
export default TaskList;
