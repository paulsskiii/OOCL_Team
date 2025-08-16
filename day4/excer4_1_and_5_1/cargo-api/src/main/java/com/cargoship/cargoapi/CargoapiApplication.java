package com.cargoship.cargoapi;

import com.cargoship.cargoapi.model.Ship;
import com.cargoship.cargoapi.repository.ShipRepository;
import com.cargoship.cargoapi.service.ShipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CargoapiApplication {

	@Autowired
	private static ShipRepository shipRepository = new ShipRepository();

	@Autowired
	private static ShipService shipService;
	
	public static void main(String[] args) {
		shipService = new ShipService (shipRepository);

		System.out.println ("All ships");
		for (Ship ship : shipService.getAllShips ())
			System.out.println (ship);

		System.out.println ("\nNon port ships: ");
		System.out.println (shipService.getShipDetails ((long)1).get ());
		System.out.println (shipService.getShipDetails ((long)4));
	}

}
