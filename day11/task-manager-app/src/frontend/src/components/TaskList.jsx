import React, { useEffect, useContext, useState } from "react";

import taskService from "../api/taskService";

import TaskContext from "../context/TaskContext";

import { Link } from "react-router-dom";

const TaskList = () => {
  const { tasks, dispatch } = useContext(TaskContext);

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    taskService
      .getAllTasks()

      .then((res) => {
        dispatch({ type: "SET_TASKS", payload: res.data });

        setLoading(false);
      })

      .catch((err) => {
        console.error(err);

        setLoading(false);
      });
  }, [dispatch]);

  const handleDelete = (id) => {
    taskService.deleteTask(id).then(() => {
      dispatch({ type: "DELETE_TASK", payload: id });
    });
  };

  if (loading) return <p>Loading tasks...</p>;

  return (
    <div>
      <h2>Task List</h2>

      {tasks.length === 0 ? (
        <p>No tasks available.</p>
      ) : (
        <ul>
          {tasks.map((task) => (
            <li key={task.id}>
              {task.title} - {task.completed ? "✅ Done" : "❌ Not Done"}
              <Link to={`/edit/${task.id}`}> Edit</Link>
              <button onClick={() => handleDelete(task.id)}>Delete</button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default TaskList;
