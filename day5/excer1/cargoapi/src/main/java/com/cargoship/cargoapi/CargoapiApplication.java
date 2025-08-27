package com.cargoship.cargoapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cargoship.cargoapi.component.PortAvailabilityChecker;
import com.cargoship.cargoapi.repository.ShipRepository;
import com.cargoship.cargoapi.service.ShipService;

@SpringBootApplication
public class CargoapiApplication {

	public static void main(String[] args) {
		long shipId = 1;
		ShipRepository shipRepository = new ShipRepository();
		PortAvailabilityChecker portAvailabilityChecker = new PortAvailabilityChecker();
		ShipService shipService = new ShipService(shipRepository, portAvailabilityChecker);

		SpringApplication.run(CargoapiApplication.class, args);
		
		System.out.println("All Cargoes: " + shipService.getAllShips());
		System.out.println("Details of ship " + shipService.getShipDetails(shipId));
		
		shipService.checkPortAvailability("Damaged PORT");
		shipService.checkPortAvailability("Hong Kong");

	}

}
