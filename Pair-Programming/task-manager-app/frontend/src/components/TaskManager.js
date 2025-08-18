import React, { useEffect } from "react";
import { useTaskContext } from "../context/TaskContext";
import { taskService } from "../api/taskService";
function TaskManager() {
  const { state, dispatch } = useTaskContext();
  const { tasks, loading, error } = state;
  
  useEffect(() => {
    fetchTasks();
    
  }, []);
  const fetchTasks = async () => {
debugger
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
  const deleteTask = async (id) => {
    try {
      await taskService.deleteTask(id);
      dispatch({ type: "DELETE_TASK", payload: id });
    } catch (err) {
      dispatch({ type: "SET_ERROR", payload: "Failed to delete task" });
    }
  };
  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;
  return (
    <div>
      {tasks.map((task) => (
        <div key={task.id}>
          <h3>{task.title}</h3>
          <button onClick={() => deleteTask(task.id)}>Delete</button>
        </div>
      ))}
    </div>
  );
  
}

export default TaskManager;
