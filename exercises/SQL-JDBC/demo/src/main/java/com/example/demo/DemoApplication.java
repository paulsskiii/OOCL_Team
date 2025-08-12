package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        DBConnection.getConnection ();
		
		System.out.println ("\nStatement ==============");
		DBConnection.getStatement ();

		System.out.println ("\nGet Prepared ==========");
		DBConnection.getPrep(67);

		System.out.println ("\nGet Callable ==========");
		DBConnection.getCall(67);
    }

}
