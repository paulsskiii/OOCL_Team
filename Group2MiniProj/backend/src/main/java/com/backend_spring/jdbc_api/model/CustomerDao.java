package com.backend_spring.jdbc_api.model;

import java.util.List;

public interface CustomerDao {
    public List<Customer> findAll();
}
