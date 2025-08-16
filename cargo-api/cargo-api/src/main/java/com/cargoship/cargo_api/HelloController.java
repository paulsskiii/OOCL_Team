// First REST Endpoint (@RestController, @GetMapping)

// com.cargoship.cargoapi.controller.HelloController.java
package com.cargoship.cargo_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation makes it a REST controller
public class HelloController {

    @GetMapping("/hello") // Maps HTTP GET requests to /hello
    public String helloCargo() {
        return "Hello from Cargo API!";
    }
}


