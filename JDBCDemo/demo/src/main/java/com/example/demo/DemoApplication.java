package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Statements.Statements;



    @SpringBootApplication
    public class DemoApplication {

        public static void main(String[] args) {

            // Statements.selectAll();
            // Statements.trackPackageJourney();
            Statements.getCustomerDeliveryHistory(1);
            Statements.MostActiveDeliveryCity(1);
        }

    }