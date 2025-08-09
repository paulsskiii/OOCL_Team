# Cargo Shipping System - Starter Code

## Project Structure

```
cargo-shipping-system/
│
├── config-repo/                         # Git-based config repo
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
│   │       com/example/cargoservice/MessageController.java
│   └── src/main/resources/bootstrap.yml
│       src/main/resources/application.yml
│
├── shipping-portal/
│   ├── pom.xml
│   ├── src/main/java/com/example/shippingportal/ShippingPortalApplication.java
│   │       com/example/shippingportal/ShippingPortalController.java
│   └── src/main/resources/application.yml
│
└── tracking-service/
    ├── pom.xml
    ├── src/main/java/com/example/trackingservice/TrackingServiceApplication.java
    │       com/example/trackingservice/model/TrackingUpdate.java
    │       com/example/trackingservice/repository/TrackingUpdateRepository.java
    │       com/example/trackingservice/service/TrackingService.java
    │       com/example/trackingservice/controller/TrackingController.java
    └── src/main/resources/bootstrap.yml
        src/main/resources/application.yml
```

---

## Config Repo (`config-repo/`)

### `cargo-service-dev.yml`
```yaml
welcome:
  message: Development Cargo Service!
shipping:
  fee: 5.00
```

### `cargo-service-prod.yml`
```yaml
welcome:
  message: Production Cargo Service is live!
shipping:
  fee: 15.00
```

---

## Config Server (`config-server`)

**`ConfigServerApplication.java`**
```java
package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
```

**`application.yml`**
```yaml
server:
  port: 8888

spring:
  cloud:
    config:
      server:
        git:
          uri: file:///${user.home}/path/to/config-repo
```

---

## Eureka Server (`eureka-server`)

**`EurekaServerApplication.java`**
```java
package com.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

**`application.yml`**
```yaml
server:
  port: 8761

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
  instance:
    hostname: localhost
```

---

## Cargo Service (`cargo-service`)

**`bootstrap.yml`**
```yaml
spring:
  application:
    name: cargo-service
  cloud:
    config:
      uri: http://localhost:8888
      fail-fast: true

server:
  port: 8081
```

**`application.yml`**
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:cargodb
    driverClassName: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: update
  h2:
    console:
      enabled: true
      path: /h2-console

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```

**`CargoServiceApplication.java`**
```java
package com.example.cargoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CargoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CargoServiceApplication.class, args);
    }
}
```

**`MessageController.java`**
```java
package com.example.cargoservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Value("${shipping.fee}")
    private double shippingFee;

    @GetMapping("/message")
    public String getMessage() {
        return welcomeMessage + " Shipping Fee: $" + shippingFee;
    }
}
```

---

## Shipping Portal (`shipping-portal`)

**`application.yml`**
```yaml
server:
  port: 8080

spring:
  application:
    name: shipping-portal

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```

**`ShippingPortalApplication.java`**
```java
package com.example.shippingportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ShippingPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShippingPortalApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

**`ShippingPortalController.java`**
```java
package com.example.shippingportal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShippingPortalController {
    private final RestTemplate restTemplate;

    public ShippingPortalController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/portal/cargo")
    public String getCargo() {
        return restTemplate.getForObject("http://CARGO-SERVICE/cargo", String.class);
    }
}
```

---

## Tracking Service (`tracking-service`)

**`bootstrap.yml`**
```yaml
spring:
  application:
    name: tracking-service
  cloud:
    config:
      uri: http://localhost:8888
      fail-fast: true

server:
  port: 8082
```

**`application.yml`**
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:trackingdb
    driverClassName: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: update
  h2:
    console:
      enabled: true
      path: /h2-console

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```

**`TrackingServiceApplication.java`**
```java
package com.example.trackingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class TrackingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrackingServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

**`TrackingUpdate.java`**
```java
package com.example.trackingservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackingUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackingId;
    private Long cargoItemId;
    private String status;
    private String location;
    private LocalDateTime timestamp;
}
```
