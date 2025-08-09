package com.cargoship.cargoapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cargoship.cargoapi.component.PortAvailabilityChecker;
import com.cargoship.cargoapi.repository.ShipRepository;
import com.cargoship.cargoapi.service.ShipService;

@SpringBootApplication
public class CargoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargoapiApplication.class, args);
		ShipService shipService = new ShipService(new ShipRepository(), new PortAvailabilityChecker());
		System.out.println(shipService.getAllShips());
	}

}
