package com.cargoship.cargoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cargoship.cargoapi.model.Ship;
import com.cargoship.cargoapi.service.ShipService;

@SpringBootApplication
public class CargoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargoapiApplication.class, args);

		
	}

}
