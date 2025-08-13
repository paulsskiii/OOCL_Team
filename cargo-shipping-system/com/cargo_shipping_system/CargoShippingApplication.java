package com.cargo_shipping_system;

import com.cargo_shipping_system.callable.DBProcedureCaller;
import com.cargo_shipping_system.connection.DBConnection;
import java.sql.Connection;
import java.util.Scanner;

public class CargoShippingApplication {
    public static void main(String[] args) {
        Connection conn = null;
        DBProcedureCaller caller = null;
        Scanner scanner = new Scanner(System.in);

        try {
            DBConnection dbConnection = new DBConnection();
            conn = dbConnection.getConnection();
            caller = new DBProcedureCaller(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Select which report to see (1-4): ");
        String reportType = scanner.next();

        switch (reportType){
            case "1":
                break;
            case "2":
            System.out.print("\n\nGetting most active delivery cities...");
            caller.most_active_delivery_cities(conn);
                break;
            case "3":
                break;
            case "4":
                System.out.print("\n\nEnter Courier ID to check scorecard: ");
                String courierInput = scanner.next();

                caller.getCourierScoreCard(courierInput);
                break;
            default:
                System.out.println("No given operation found!");
                break;
        }
    }
}
