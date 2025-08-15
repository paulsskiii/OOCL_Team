package com.backend_spring.jdbc_api.model;

import java.util.List;

public interface PackageDao {
    public List<Package> findAll();
    public List<Package> findAllBySender(int senderId);
}
