import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api";

export const getAllCustomers = () =>
	axios.get(REST_API_BASE_URL + "/customers");

export const getCustomerCount = () =>
	axios.get(REST_API_BASE_URL + "/customerCount");

export const getCustomerById = (customerId) =>
	axios.get(REST_API_BASE_URL + "/customer/" + customerId);
