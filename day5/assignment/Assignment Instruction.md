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



# Cargo Shipping System - Project Structure

cargo-shipping-system/
├── config-repo/                       # Git-based config repo
│   ├── cargo-service-dev.yml
│   ├── cargo-service-prod.yml
│   └── tracking-service.yml
│
├── config-server/
│   ├── pom.xml
│   └── src/main/java/com/example/configserver/ConfigServerApplication.java
│       src/main/resources/application.yml
│
├── eureka-server/
│   ├── pom.xml
│   └── src/main/java/com/example/eurekaserver/EurekaServerApplication.java
│       src/main/resources/application.yml
│
├── cargo-service/
│   ├── pom.xml
│   ├── src/main/java/com/example/cargoservice/CargoServiceApplication.java
│   │   └── com/example/cargoservice/MessageController.java
│   └── src/main/resources/
│       ├── bootstrap.yml
│       └── application.yml
│
├── shipping-portal/
│   ├── pom.xml
│   ├── src/main/java/com/example/shippingportal/ShippingPortalApplication.java
│   │   └── com/example/shippingportal/ShippingPortalController.java
│   └── src/main/resources/application.yml
│
└── tracking-service/
    ├── pom.xml
    ├── src/main/java/com/example/trackingservice/TrackingServiceApplication.java
    │   ├── com/example/trackingservice/model/TrackingUpdate.java
    │   ├── com/example/trackingservice/repository/TrackingUpdateRepository.java
    │   ├── com/example/trackingservice/service/TrackingService.java
    │   └── com/example/trackingservice/controller/TrackingController.java
    └── src/main/resources/
        ├── bootstrap.yml
        └── application.yml