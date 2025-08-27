On your existing **Exercise 1**, proceed to do **Exercise 2** as follows:

---

## Exercise 2.1: Advanced Config Server for Cargo Service

1. Add environment-specific configurations (e.g., `application-dev.yml`, `application-prod.yml`) to the Config Server’s Git repository.  
2. Show how to activate different profiles in the **cargo-service** to load different configurations.  
3. Add a new configuration property that determines a **shipping fee** and display it in the cargo service response.  

---

## Exercise 2.2: Multiple Instances of Cargo Service

1. Run multiple instances of the **cargo-service** on different ports.  
2. Observe how **Eureka Server** registers all instances.  
3. *(Optional challenge)*: Use `spring.application.instance_id` to provide unique IDs for each instance.  

---

## Exercise 2.3: Basic Client-Side Load Balancing

1. Create a new simple Spring Boot application called **shipping-portal** (or similar).  
2. Make the **shipping-portal** a Eureka Client.  
3. Use `@LoadBalanced RestTemplate` in **shipping-portal** to call the **cargo-service** by its Eureka name (e.g., `http://CARGO-SERVICE/cargo`).  
4. Demonstrate calls being distributed across multiple **cargo-service** instances.  
