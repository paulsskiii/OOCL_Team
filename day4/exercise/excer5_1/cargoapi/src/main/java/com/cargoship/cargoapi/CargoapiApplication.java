package com.cargoship.cargoapi;

import com.cargoship.cargoapi.repository.ShipRepository;
import com.cargoship.cargoapi.service.ShipService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CargoapiApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CargoapiApplication.class, args);
		ShipService shipService = new ShipService(new ShipRepository());

		shipService.checkPortAvailability("Maynilad");
		shipService.checkPortAvailability("damaged port");

	}

}
