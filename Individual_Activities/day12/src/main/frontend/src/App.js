import React, { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [tasks, setTasks] = useState([]);
  const [newTaskTitle, setNewTaskTitle] = useState('');

  // Function to fetch tasks from the backend
  const fetchTasks = async () => {
    try {
      const response = await fetch('/api/tasks');
      const data = await response.json();
      setTasks(data);
    } catch (error) {
      console.error("Failed to fetch tasks:", error);
    }
  };

  // Function to add a new task
  const handleAddTask = async (e) => {
    e.preventDefault();
    if (!newTaskTitle) return;

    try {
      await fetch('/api/tasks', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ title: newTaskTitle, completed: false }),
      });
      setNewTaskTitle('');
      fetchTasks(); // Refresh the list
    } catch (error) {
      console.error("Failed to add task:", error);
    }
  };

  // Function to delete a task
  const handleDeleteTask = async (id) => {
    try {
      await fetch(`/api/tasks/${id}`, {
        method: 'DELETE',
      });
      fetchTasks(); // Refresh the list
    } catch (error) {
      console.error("Failed to delete task:", error);
    }
  };

  // Fetch tasks on component mount
  useEffect(() => {
    fetchTasks();
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <h1>Task Manager</h1>
        <form onSubmit={handleAddTask}>
          <input
            type="text"
            placeholder="Add a new task..."
            value={newTaskTitle}
            onChange={(e) => setNewTaskTitle(e.target.value)}
          />
          <button type="submit">Add Task</button>
        </form>
        <ul>
          {tasks.map(task => (
            <li key={task.id}>
              {task.title}
              <button onClick={() => handleDeleteTask(task.id)}>Delete</button>
            </li>
          ))}
        </ul>
      </header>
    </div>
  );
}

export default App;
