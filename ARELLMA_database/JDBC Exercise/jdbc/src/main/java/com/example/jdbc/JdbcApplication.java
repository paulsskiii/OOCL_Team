package com.example.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class JdbcApplication {

	    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/group3_miniproject";
    private static final String USER = "root";

    private static final String PASSWORD = "";

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

        if(conn != null){

			String sql = "SELECT c.first_name, c.last_name FROM customers c";
			
			try (Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
					while(rs.next()){
						String firstName = rs.getString("first_name");
						String lastName = rs.getString("last_name");
						
						System.out.printf("First Name: %s Last Name: %s%n", firstName, lastName);
						
					}
					stmt.close();
				} catch (SQLException e){
					e.printStackTrace();
				}

				PreparedStatement pstmt = null;

				try{
					String SQL = "SELECT CONCAT(c.first_name, ' ', c.last_name) AS 'Customer Name', p.contents_description FROM packages p INNER JOIN DELIVERY_DETAILS d ON p.delivery_details_id = d.id INNER JOIN CUSTOMERS c on d.sender_id = c.id";
					pstmt = conn.prepareStatement(SQL);
					System.out.printf("FETCHED: ", pstmt);
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()){
						String customerName = rs.getString("Customer Name");
						String contentsDescription = rs.getString("contents_description");

						System.out.printf("Customer Name: %s, Contents Description: %s%n", customerName, contentsDescription);
					}

					pstmt.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
        } else{
            System.out.println("Connection test failed. Please check your database server and credentials");
        }
    }


}
