import React, { useEffect } from "react";
import { Link } from "react-router-dom";
import { useTaskContext } from "../context/TaskContext";
import { taskService } from "../api/taskService";

function TaskList() {
  const { state, dispatch } = useTaskContext();
  const { tasks, loading, error } = state;

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    dispatch({ type: "SET_LOADING", payload: true });
    try {
      const response = await taskService.getAllTasks();
      dispatch({ type: "SET_TASKS", payload: response.data });
    } catch (err) {
      dispatch({ type: "SET_ERROR", payload: "Failed to fetch tasks" });
    } finally {
      dispatch({ type: "SET_LOADING", payload: false });
    }
  };

  if (loading) return <div>Loading tasks...</div>;

  if (error) return <div>Error: {error}</div>;
  
  return (
    <div style={{ padding: "20px" }}>
      <h2>Task List</h2>
      {tasks.length === 0 ? (
        <div>
          <p>No tasks found.</p>
          <Link to="/create">Create your first task</Link>
        </div>
      ) : (
        tasks.map((task) => (
          <div
            key={task.id}
            style={{
              border: "1px solid #ccc",
              padding: "10px",
              margin: "10px 0",
            }}
          >
            <h3>{task.title}</h3>
            <p>{task.description}</p>
            <p>Status: {task.completed ? "✅ Completed" : "⏳ Pending"}</p>
            <Link to={`/edit/${task.id}`}>Edit</Link>
          </div>
        ))
      )}
    </div>
  );
}
export default TaskList;
