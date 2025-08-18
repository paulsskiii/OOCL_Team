import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/customers";

export const getAllCustomers = () => axios.get(REST_API_BASE_URL);

export const getCustomerCount = (customerId) =>
	axios.get(REST_API_BASE_URL + "/count");

export const getCustomerById = (customerId) =>
	axios.get(REST_API_BASE_URL + "/" + customerId);
