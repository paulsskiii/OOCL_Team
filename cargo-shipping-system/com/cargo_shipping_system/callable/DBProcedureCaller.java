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

}
