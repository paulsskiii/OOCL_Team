import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';
const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json'
  }
});

export const customerService = {
  getAll: () => api.get('/users'),
  // getById: (id:number) => api.get(`/products/${id}`),
};
export default api;