package com.jdbc.exercise.jdcbexercise;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Callable;

import javax.print.DocFlavor.READER;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdbc.exercise.jdcbexercise.model.DBConnection;

@SpringBootApplication
public class JdcbexerciseApplication {

	public static void main(String[] args) {
		// SpringApplication.run(JdcbexerciseApplication.class, args);
		Connection con = DBConnection.getConnection();
		String SQL = "{CALL GET_CUSTOMER_DELIVERY_HISTORY(?)}";
		
		if(con != null){
			try{
				
				CallableStatement stmt = con.prepareCall(SQL);
				stmt.setInt(1, 24);
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				rs.next();
				System.out.println("----Customer Delivery History Report----");
				System.out.println(rs.getString("FULL_NAME"));
				System.out.println(rs.getString("SENT"));
				System.out.println(rs.getString("RECEIVED"));
				
				stmt.getMoreResults();
				ResultSet rs1 = stmt.getResultSet();
				
				System.out.println("ID | DELIVERY_DATE | PACKAGE_STATUS | COURIER_NAME");
				
				while(rs1.next()){
					System.out.println(	rs1.getInt("ID") +"   "+ 
										rs1.getDate("DELIVERY_DATE") +"       "+ 
										rs1.getString("PACKAGE_STATUS") +"       "+ 
										rs1.getString("COURIER_NAME")
					);
				};
				
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println(e.getErrorCode());
			}
			
			DBConnection.closeConnection(con);
		}
	}

}
