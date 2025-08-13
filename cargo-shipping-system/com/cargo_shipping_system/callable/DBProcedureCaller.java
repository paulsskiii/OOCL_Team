package com.cargo_shipping_system.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBProcedureCaller {

    private Connection connection;

    public DBProcedureCaller(Connection connection) {
        this.connection = connection;
    }
    
    public void getCourierScoreCard(String courier_id) {
        try {
            CallableStatement callableStatement = connection.prepareCall("{call GetCourierScoreCard(?)}");

            callableStatement.setString(1, courier_id);
            boolean hadResults = callableStatement.execute();

            while (hadResults) {
                ResultSet resultSet = callableStatement.getResultSet();

                while (resultSet.next()) {
                    String courierFullName = resultSet.getString("courier_name");
                    String totalDelivered = resultSet.getString("total_number_of_deliveries");
                    double avgDeliveryTime = resultSet.getDouble("average_delivery_time");
                    int numberOfFailedDeliveries = resultSet.getInt("number_of_failed_deliveries");
                    int numberOfUniqueCityDelivered = resultSet.getInt("number_of_unique_city_deliveries");
                    double calculatedReliabilityScore = resultSet.getDouble("calculated_reliability_score");

                    
                    System.out.println("\n============ COURIER INFO ==============\n");
                    System.out.println("Full Name: " + courierFullName + "\nTotal Deliveries: " + totalDelivered + 
                    "\nAverage Delivery Time: " + avgDeliveryTime + "\nNumber of Failed Deliveries: " + numberOfFailedDeliveries + 
                    "\nNumber of Cities Delivered To: " + numberOfUniqueCityDelivered + "\nCalculated Reliability Score: " + calculatedReliabilityScore);
                    
                    String scoreInterpretation = "";

                    if (calculatedReliabilityScore >= 80)
                        scoreInterpretation = "Top Performer";
                    else if (calculatedReliabilityScore >= 50 && calculatedReliabilityScore <= 79)
                        scoreInterpretation = "Reliable";
                    else
                        scoreInterpretation = "Needs Improvement";
                        
                    System.out.println("Overall score interpretation: " + scoreInterpretation);
                }
                hadResults = callableStatement.getMoreResults();  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void most_active_delivery_cities(Connection conn) {
        try {
            String query = "{CALL most_active_delivery_cities()}";
            CallableStatement cstmt = conn.prepareCall(query);
            // cstmt.setInt(1, 12);

            ResultSet rs = cstmt.executeQuery();
            
            
            while (rs.next()) {
                String city = rs.getString("city_name");
                int pkg_delivered = rs.getInt("packages_delivered");
                String courier = rs.getString("most_frequent_courier");
                float avg = rs.getFloat("avg_delivery_time_days");
                System.out.printf("City: %s \nPackages Delivered: %s \nMost Frequent Courier: %s \naAVG Delivery Time: %s \n", city, pkg_delivered, courier, avg);
                System.out.println("---------------------------------------------------");
            }
            rs.close();
            cstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error", e);
        }
    }

}
