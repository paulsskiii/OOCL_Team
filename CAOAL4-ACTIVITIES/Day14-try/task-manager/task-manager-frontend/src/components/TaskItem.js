import React from "react";
// import DOMPurify from 'dompurify';

const TaskItem = ({ task, onToggle, onDelete }) => {
  // const sanitizedTitle = DOMPurify.sanitize(task.title);
  // const sanitizedDescription = DOMPurify.sanitize(task.description);

  return (
    <div className={`task-item ${task.completed ? "completed" : ""}`}>
      <div className="task-content">
        <h3>{task.title}</h3>
        <p>{task.description}</p>
        {/* <h3 dangerouslySetInnerHTML={{ __html: sanitizedTitle }} />
        <p dangerouslySetInnerHTML={{ __html: sanitizedDescription }} /> */}
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
