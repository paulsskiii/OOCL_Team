import axios from "axios";
const API_URL = "http://localhost:8080/api/tasks";

// GET - Read data (no body needed)
const getTasks = async () => {
  const response = await axios.get("/api/tasks");
  return response.data;
};
// POST - Create data (body contains new data)
const createTask = async (newTask) => {
  const response = await axios.post("/api/tasks", newTask);
  return response.data;
};
// PUT - Update data (body contains updated data)
const updateTask = async (id, updatedTask) => {
  const response = await axios.put(`/api/tasks/${id}`, updatedTask);
  return response.data;
};
// DELETE - Remove data (no body needed)
const deleteTask = async (id) => {
  await axios.delete(`/api/tasks/${id}`);
};

export const taskService = {
  getAllTasks: () => axios.get(API_URL),
  createTask: (task) => axios.post(API_URL, task),
  updateTask: (id, task) => axios.put(`${API_URL}/${id}`, task),
  deleteTask: (id) => axios.delete(`${API_URL}/${id}`),
};
