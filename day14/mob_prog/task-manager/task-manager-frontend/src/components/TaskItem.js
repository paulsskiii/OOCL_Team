import React from "react";

const TaskItem = ({ task, onToggle, onDelete }) => {
  return (
    <div className={`task-item ${task.completed ? "completed" : ""}`}>
      <div className="task-content">
        <h3>{task.title}</h3>
        <p>{task.description}</p>
        <small>Created: {new Date(task.createdAt).toLocaleDateString()}</small>
      </div>
      <div className="task-actions">
        <button
          onClick={() => onToggle(task.id, !task.completed)}
          className={task.completed ? "btn-undo" : "btn-complete"}
        >
          {task.completed ? "Undo" : "Complete"}
        </button>
        <button onClick={() => onDelete(task.id)} className="btn-delete">
          Delete
        </button>
      </div>
    </div>
  );
};
export default TaskItem;
