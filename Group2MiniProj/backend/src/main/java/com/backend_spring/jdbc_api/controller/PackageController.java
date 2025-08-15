package com.backend_spring.jdbc_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_spring.jdbc_api.model.Package;
import com.backend_spring.jdbc_api.model.PackageDao;
import com.backend_spring.jdbc_api.model.PackageDaoImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173")
public class PackageController {
    //initialize
    private PackageDao packageDao = new PackageDaoImpl();

    @GetMapping("/user/{id}")
    public List<Package> getCustomer(@PathVariable int id) {
        return packageDao.findAllBySender(id);
    }
}
