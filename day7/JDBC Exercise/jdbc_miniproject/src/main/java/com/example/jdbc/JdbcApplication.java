package com.example.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.CallableStatement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class JdbcApplication {

	    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/group3_miniproject";
    private static final String USER = "root";

    private static final String PASSWORD = "admin";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("DB Connection established successfully!");
        } catch (SQLException e){
			 System.out.println("DB Connection failure to be established.");
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        if(connection != null){
            try{
                connection.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
		SpringApplication.run(JdbcApplication.class, args);
        Connection conn = JdbcApplication.getConnection();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Input Courier ID:");

		int courierID = scanner.nextInt();

        if(conn != null){

				try{

					CallableStatement cstmt = conn.prepareCall("{CALL GetCourierScorecard(?)}");

					cstmt.setInt(1, courierID);

					ResultSet rs = cstmt.executeQuery();
					
					while(rs.next()){
						String courierName = rs.getString("CourierName");
						int totalDelivered = rs.getInt("TotalDelivered");
						int failedDelivered = rs.getInt("FailedDeliveries");
						float averageDeliveryTime = rs.getFloat("AverageDeliveryTime");
						int cityCoverage = rs.getInt("CityCoverage");
						float reliabilityScore = rs.getFloat("ReliabilityScore");

						System.out.printf("----SCORECARD of Courier: %s%nTotal Delivered: %d%nFailed Delivery: %d%nAverage Delivery Time: %f hours%nCity Coverage: %d----%n", courierName, totalDelivered, failedDelivered, averageDeliveryTime, cityCoverage);
						
						if(reliabilityScore >= 80){
							System.out.printf("%s is a Top Performer with a Reliability Score of %f :D%n", courierName, reliabilityScore);
						}
						else if(reliabilityScore <= 79 && reliabilityScore >= 50 ){
							System.out.printf("%s is a Reliable Courier with a Reliability Score of %f:-)%n", courierName, reliabilityScore);
						}
						else{
							System.out.printf("%s needs improvement due to a low Reliability Score of %f :-(%n ", courierName, reliabilityScore);
						}
					}
					cstmt.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
				scanner.close();
        } else{
            System.out.println("Connection test failed. Please check your database server and credentials :-(");
        }
    }


}
