import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { useTaskContext } from "../context/TaskContext";
import { taskService } from "../api/taskService";
import { SearchTask } from "./SearchTask"

function TaskList() {
  const { state, dispatch } = useTaskContext();
  const { tasks, loading, error } = state;
  const [searchTasks, setSearchTasks] = useState([]);
  const [filter, setFilter] = useState("all");

  useEffect(() => {
    fetchTasks(filter);
  }, [filter]);

  useEffect(() => {
    console.log('Tasks updated:', tasks);
  }, [tasks]);

  useEffect(() => {
    const timer = setInterval(() => fetchTasks(), 30000);
    return () => clearInterval(timer); // Cleanup when unmounting
  }, []);

  const fetchTasks = async (status = "all") => {
    dispatch({ type: "SET_LOADING", payload: true });

    try {
      const response = await taskService.getAllTasks(status);
      dispatch({ type: "SET_TASKS", payload: response.data });
    } catch (err) {
      dispatch({ type: "SET_ERROR", payload: "Failed to fetch tasks" });
    } finally {
      dispatch({ type: "SET_LOADING", payload: false });
    }
  };

  const deleteTask = async (id, title) => {
    if (window.confirm(`Are you sure you want to delete "${title}"?`)) {
      try {
        await taskService.deleteTask(id);
        dispatch({ type: "DELETE_TASK", payload: id });
      } catch (error) {
        alert("Failed to delete task");
      }
    }
  };

  const toggleComplete = async (task) => {
    try {
      const updatedTask = { ...task, completed: !task.completed };
      const response = await taskService.updateTask(task.id, updatedTask);
      dispatch({ type: "UPDATE_TASK", payload: response.data });
    } catch (error) {
      alert("Failed to update task");
    }
  };

  if (loading) return <div>Loading tasks...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <div style={{ padding: "20px" }}>
      <h2>
        Task List ({searchTasks.length > 0 ? searchTasks.length : tasks.length} tasks)
      </h2>
      <SearchTask setSearchTasks={setSearchTasks} />
      <div style={{ marginBottom: "20px" }}>
        <label htmlFor="filter">Filter tasks: </label>
        <select
          id="filter"
          value={filter}
          onChange={(e) => setFilter(e.target.value)}
          style={{ padding: "5px", marginLeft: "10px" }}
        >
          <option value="all">All</option>
          <option value={true}>Completed</option>
          <option value={false}>Pending</option>
        </select>
      </div>
      {tasks.length === 0 ? (
        <div>
          <p>No tasks found.</p>
          <Link
            to="/create"
            style={{
              padding: "10px 20px",
              backgroundColor: "#007bff",
              color: "white",
              textDecoration: "",
            }}
          >
            Create your first task
          </Link>
        </div>
      ) : (
        <div>
          {(searchTasks.length > 0 ? searchTasks : tasks).map((task) => (
            <div
              key={task.id}
              style={{
                border: "1px solid #ccc",
                padding: "15px",
                margin: "10px 0",
                backgroundColor: task.completed ? "#f8f9fa" : "white",
              }}
            >
              <h3
                style={{
                  textDecoration: task.completed ? "line-through" : "none",
                }}
              >
                {task.title}
              </h3>
              <p style={{ color: task.completed ? "#6c757d" : "black" }}>
                {task.description}
              </p>
              <p>Status: {task.completed ? "✅ Completed" : "⏳ Pending"}</p>
              <div style={{ marginTop: "10px" }}>
                <button
                  onClick={() => toggleComplete(task)}
                  style={{
                    padding: "5px 10px",
                    marginRight: "10px",
                    backgroundColor: task.completed ? "#28a745" : "#ffc107",
                    color: "white",
                    border: "none",
                  }}
                >
                  {task.completed ? "Mark Incomplete" : "Mark Complete"}
                </button>
                <Link
                  to={`/edit/${task.id}`}
                  style={{
                    padding: "5px 10px",
                    marginRight: "10px",
                    backgroundColor: "#007bff",
                    color: "white",
                    textDecoration: "none",
                  }}
                >
                  Edit
                </Link>
                <button
                  onClick={() => deleteTask(task.id, task.title)}
                  style={{
                    padding: "5px 10px",
                    backgroundColor: "#dc3545",
                    color: "white",
                    border: "none",
                  }}
                >
                  Delete
                </button>
              </div>
            </div>
          ))}
          <div style={{ marginTop: "20px" }}>
            <Link
              to="/create"
              style={{
                padding: "10px 20px",
                backgroundColor: "#28a745",
                color: "white",
                textDecoration: "none",
              }}
            >
              Add New Task
            </Link>
          </div>
        </div>
      )}
    </div>
  );
}
export default TaskList;
