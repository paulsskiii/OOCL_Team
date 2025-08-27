import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useTaskContext } from "../context/TaskContext";
import taskService from "../api/taskService";

function CreateTask() {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [submitting, setSubmitting] = useState(false);
  const navigate = useNavigate();
  const { dispatch } = useTaskContext();
  const handleSubmit = async (e) => {
    e.preventDefault();
    setSubmitting(true);
    try {
      const newTask = { title, description };
      const response = await taskService.createTask(newTask);
      dispatch({ type: "ADD_TASK", payload: response.data });
      navigate("/"); 
    } catch (error) {
      alert("Failed to create task");
    } finally {
      setSubmitting(false);
    }
  };
  return (
    <div style={{ padding: "20px" }}>
      <h2>Create New Task</h2>
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
        <button
          type="submit"
          disabled={submitting}
          style={{ padding: "10px 20px" }}
        >
          {submitting ? "Creating..." : "Create Task"}
        </button>
      </form>
    </div>
  );
}
export default CreateTask;
