package com.example.jdbc.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(JdbcApplication.class, args);
		FetchData fetchData = new FetchData();

		fetchData.testNormalQuery();
		System.out.println();
		fetchData.testStoredProcedure();
	}

}
