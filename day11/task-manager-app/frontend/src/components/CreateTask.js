import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useTaskContext } from "../context/TaskContext";
import { taskService } from "../api/taskService";
function CreateTask() {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [submitting, setSubmitting] = useState(false);
  const navigate = useNavigate();
  const { dispatch } = useTaskContext();
  // Input validation in React
  const validateTask = (task) => {
    const errors = {};
    if (!task.title || task.title.trim().length < 3) {
      errors.title = "Title must be at least 3 characters";
    }
    if (task.title && task.title.length > 100) {
      errors.title = "Title must be less than 100 characters";
    }
    return errors;
  };
  // Sanitize user input
  const sanitizeInput = (input) => {
    return input
      .trim()
      .replace(/<script\b[^<]*(?:(?!<\/script>)<[^<]*)*<\/script>/gi, "");
  };



  const handleSubmit = async (e) => {
    e.preventDefault();
    setSubmitting(true);
    try {
        setTitle(sanitizeInput(title));
        setDescription(sanitizeInput(description));
      const newTask = { title, description };
      const isError = validateTask(newTask);
      console.log (isError);
      if(isError.title !== undefined){
        throw new Error(isError.title);
      }
      const response = await taskService.createTask(newTask);
      dispatch({ type: "ADD_TASK", payload: response.data });
      navigate("/"); // Redirect to task list
    } catch (error) {
      alert("Failed to create task. " + error.message);
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
