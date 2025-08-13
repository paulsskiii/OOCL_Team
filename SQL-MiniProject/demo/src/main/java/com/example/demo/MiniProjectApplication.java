package com.example.demo;

import java.sql.Connection;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniProjectApplication {
	public static void main(String[] args) {
		Connection con = DBConnection.getConnection ();
		int nChoice = 0;

		if (con != null) {
				Scanner kbIn = new Scanner (System.in);
				
				System.out.println ("What would you like to view? ");
				System.out.println ("\t1. View customer's delivery history");
				System.out.println ("\t2. View most active cities");
				System.out.println ("\t3. View step-by-step journey of your package");
				System.out.println ("\t4. View a courier's score");
				System.out.print("Input the number of your choice: ");

				nChoice = kbIn.nextInt ();
				
				System.out.println ();
				switch (nChoice) {
					case 1:
						displayHistory ();
						break;
					case 2:
						displayCities ();
						break;
					case 3:
						displaySteps ();
						break;
					case 4:
						displayScore ();
						break;
					default:
						break;
				}
			kbIn.close ();
		}
		else {
			System.out.println ("Failed to establish database connection.");
			System.out.println ("Please ensure MySQL server is running before restarting application.");
		}
	}

	public static void displayHistory () {
		Scanner kbIn = new Scanner (System.in);
		int customerID;
		System.out.println ("===== View Customer's delivery history =====");
		System.out.print ("Input Customer ID to check: ");
		customerID = kbIn.nextInt ();
		kbIn.close ();

		DBConnection.displayCustomerDeliveryHistory (customerID);
	}

	public static void displayCities () {
		System.out.println ("===== Most active delivery Cities =====");
		
		DBConnection.displayMostActiveCities ();
	}

	public static void displaySteps () {
		Scanner kbIn = new Scanner (System.in);
		int packageID;
		System.out.println ("===== View step-by-step journey of Package =====");
		System.out.print ("Input Package ID to check: ");
		packageID = kbIn.nextInt ();
		kbIn.close ();

		DBConnection.displayStepByStep (packageID);
	}

	public static void displayScore () {
		Scanner kbIn = new Scanner (System.in);
		int courierID;
		System.out.println ("===== View Courier's score =====");
		System.out.print ("Input Courier ID to check: ");
		courierID = kbIn.nextInt ();
		kbIn.close ();

		DBConnection.displayCourierScore (courierID);
	}
}
