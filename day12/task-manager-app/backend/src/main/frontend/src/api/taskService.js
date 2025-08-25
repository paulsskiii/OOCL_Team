import axios from "axios";

const API_URL = "http://localhost:8080/api/tasks";

export const taskService = {
  getAllTasks: () => axios.get(API_URL),
  createTask: (task) => axios.post(API_URL, task),
  updateTask: (id, task) => axios.put(`${API_URL}/${id}`, task),
  deleteTask: (id) => axios.delete(`${API_URL}/${id}`),
};
