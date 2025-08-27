package com.cargoship.cargoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cargoship.cargoapi.component.PortAvailabilityChecker;
import com.cargoship.cargoapi.model.Ship;
import com.cargoship.cargoapi.repository.ShipRepository;
import com.cargoship.cargoapi.service.ShipService;

@SpringBootApplication
@ComponentScan
public class CargoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargoapiApplication.class, args);
		System.out.println("------------ Application is running ----------------");
		ShipRepository shipRepository = new ShipRepository();
		ShipService shipService = new ShipService(shipRepository);
		System.out.println(shipService.getAllShips());
		System.out.println(shipService.getShipDetails(101L));

		// Ship shipWithDamagedPort = new Ship(404L, "Ship 99", 3123.00, "Damaged Port");
		// Ship shipWithOkayPort = new Ship(500L, "Ship 55", 120.00, "Manila");
		PortAvailabilityChecker portAvailabilityChecker = new PortAvailabilityChecker();
		portAvailabilityChecker.setShipService(shipService);
		portAvailabilityChecker.isPortOperational("Damaged Port");
		portAvailabilityChecker.isPortOperational("Manila");
	}

}
