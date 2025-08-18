import { useState } from "react";
import { taskService } from "../api/taskService";

function TaskManager() {
  const [tasks, setTasks] = useState([]);
  const [error, setError] = useState([]);
  const [loading, setLoading] = useState(false);
  const [actionLoading, setActionLoading] = useState(false);

  const deleteTaskWithLoading = async (id) => {
    setActionLoading(true);
    try {
      await taskService.deleteTask(id);
      setTasks(tasks.filter((task) => task.id !== id));
    } catch (error) {
      setError("Failed to delete task");
    } finally {
      setActionLoading(false);
    }
  };
  return (
    <div>
      {loading && <div>Loading tasks...</div>}
      {actionLoading && <div>Processing...</div>}
      {/* Your task components */}
    </div>
  );
}

export default TaskManager;