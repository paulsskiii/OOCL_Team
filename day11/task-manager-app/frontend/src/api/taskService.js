import axios from "axios";
const API_URL = "http://localhost:8080/api/tasks";
export const taskService = {
  getAllTasks: (status) => {
    if (status === "all") {
      return axios.get(API_URL); 
    }

    const url = `${API_URL}?completed=${status}`;
    return axios.get(url); 
  },
  createTask: (task) => axios.post(API_URL, task),
  updateTask: (id, task) => axios.put(`${API_URL}/${id}`, task),
  deleteTask: (id) => axios.delete(`${API_URL}/${id}`),
  searchTask: (input) => axios.get(`${API_URL}/search?input=${input}`),
};

