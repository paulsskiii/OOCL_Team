package ita.bootcamp.miniproject;

import ita.bootcamp.miniproject.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MiniProjectApplication {

	private static CustomerService customerService;
	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);

	}

}