import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { useTaskContext } from "../context/TaskContext";
import { taskService } from "../api/taskService";

function EditTask() {
  const { id } = useParams();
  const navigate = useNavigate();
  const { state, dispatch } = useTaskContext();
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [completed, setCompleted] = useState(false);
  const [loading, setLoading] = useState(true);
  const [submitting, setSubmitting] = useState(false);

  useEffect(() => {
    const task = state.tasks.find((t) => t.id === parseInt(id));
    if (task) {
      setTitle(task.title);
      setDescription(task.description);
      setCompleted(task.completed);
      setLoading(false);
    } else {
      // Task not found in state, fetch from API
      fetchTask();
    }
  }, [id, state.tasks]);

  const fetchTask = async () => {
    try {
      const response = await taskService.getAllTasks();
      const task = response.data.find((t) => t.id === parseInt(id));
      if (task) {
        setTitle(task.title);
        setDescription(task.description);
        setCompleted(task.completed);
      } else {
        alert("Task not found");
        navigate("/");
      }
    } catch (error) {
      alert("Failed to fetch task");
      navigate("/");
    } finally {
      setLoading(false);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setSubmitting(true);
    try {
      const updatedTask = { title, description, completed };
      const response = await taskService.updateTask(id, updatedTask);
      dispatch({ type: "UPDATE_TASK", payload: response.data });
      navigate("/");
    } catch (error) {
      alert("Failed to update task");
    } finally {
      setSubmitting(false);
    }
  };

  if (loading) return <div>Loading task...</div>;

  return (
    <div style={{ padding: "20px" }}>
      <h2>Edit Task</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title:</label>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
            style={{ width: "100%", padding: "8px", margin: "8px 0" }}
          />
        </div>
        <div>
          <label>Description:</label>
          <textarea
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            style={{ width: "100%", padding: "8px", margin: "8px 0" }}
          />
        </div>
        <div>
          <label>
            <input
              type="checkbox"
              checked={completed}
              onChange={(e) => setCompleted(e.target.checked)}
            />
            Completed
          </label>
        </div>
        <button
          type="submit"
          disabled={submitting}
          style={{ padding: "10px 20px", marginRight: "10px" }}
        >
          {submitting ? "Updating..." : "Update Task"}
        </button>
        <button
          type="button"
          onClick={() => navigate("/")}
          style={{ padding: "10px 20px" }}
        >
          Cancel
        </button>
      </form>
    </div>
  );
}

export default EditTask;
