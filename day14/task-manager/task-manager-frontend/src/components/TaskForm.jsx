import React, { useState } from "react";

const TaskForm = ({ onSubmit }) => {

  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  
  const handleSubmit = (e) => {
    e.preventDefault();
    if (title.trim()) {
      onSubmit({
        title: title.trim(),
        description: description.trim(),
        completed: false,
      });
      setTitle("");
      setDescription("");
    }
  };


  return (
    <form onSubmit={handleSubmit} className="task-form">
      <h2>Add New Task</h2>
      <div className="form-group">
        <input
          type="text"
          placeholder="Task title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          required
        />
      </div>
      <div className="form-group">
        <textarea
          placeholder="Task description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          rows="3"
        />
      </div>
      <button type="submit" className="btn-submit">
        Add Task
      </button>
    </form>
  );
};

export default TaskForm;