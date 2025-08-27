package org.database;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:mysql://localhost:3306/group3_miniproject";
        String username = "root";
        String password = "";

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Package ID: ");
            int packageId = sc.nextInt();
            String sqlTest = "CALL TrackPackageJourney(" + packageId + ")";

            try (Connection conn = DriverManager.getConnection(connectionUrl, username, password);
                 PreparedStatement ps = conn.prepareStatement(sqlTest)) {

                boolean hasResults = ps.execute();

                // First result set: Package info
                if (hasResults) {
                    try (ResultSet rs = ps.getResultSet()) {
                        if (rs.next()) {
                            System.out.println("Package ID: " + rs.getInt("Package ID"));
                            System.out.println("Sender Name: " + rs.getString("Sender Name"));
                            System.out.println("Recipient Name: " + rs.getString("Recipient Name"));
                            String courierName = rs.getString("Courier Name");
                            System.out.println("Courier Name: " + (courierName != null ? courierName : "No courier currently assigned."));
                        }
                    }
                }

                // Second result set: Tracking events
                if (ps.getMoreResults()) {
                    System.out.println("\nList of Tracking Events:");
                    try (ResultSet rs2 = ps.getResultSet()) {
                        int i = 1;
                        while (rs2.next()) {
                            System.out.printf(
                                    " %d. [%s] %s | Location: %s | Status: %s%n",
                                    i,
                                    rs2.getTimestamp("Event Timestamp"),
                                    rs2.getString("Event Description"),
                                    rs2.getString("Location"),
                                    rs2.getString("Status")
                            );
                            i++;
                        }
                    }
                }

            } catch (SQLException e) {
                System.err.println("SQL Error: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}