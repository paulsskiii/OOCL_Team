package com.backend_spring.jdbc_api.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.backend_spring.jdbc_api.util.DbConnection;

public class PackageDaoImpl implements PackageDao {


    @Override
    public List<Package> findAll() {
        Connection conn = DbConnection.getConnection();
        List<Package> packages = new ArrayList<>();
        try {
            String sql = "SELECT * FROM package;";
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Package package1 = new Package();
                package1.setId(rs.getInt(1));
                package1.setWeight(rs.getInt("weight"));
                package1.setContentsDescription(rs.getString("contentsDescription"));
                // Package package = new Package();
                // package.setId(rs.getInt(0));
                // package.setFirstName(rs.getString("firstName"));
                // package.setLastName(rs.getString("lastName"));
                packages.add(package1);
            }
            conn.close();
            return packages;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("jkh");
            // TODO: handle exception
        }





        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public List<Package> findAllBySender(int senderId) {
        Connection conn = DbConnection.getConnection();
        List<Package> packages = new ArrayList<>();
        try {
            String sql = "SELECT * FROM package WHERE senderId= ? ;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, senderId);
            
            ResultSet rs = pstmt.executeQuery(sql);
            
            while (rs.next()) {
                Package package1 = new Package();
                package1.setId(rs.getInt(1));
                package1.setWeight(rs.getInt("weight"));
                package1.setContentsDescription(rs.getString("contentsDescription"));
                packages.add(package1);
            }
            conn.close();
            return packages;
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        } 


        
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

        public List<Package> findAllByRecipient(int recipientId) {
        Connection conn = DbConnection.getConnection();
        List<Package> packages = new ArrayList<>();
        try {
            String sql = "SELECT * FROM package WHERE recepientid = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, recipientId);
            
            ResultSet rs = pstmt.executeQuery(sql);
            
            while (rs.next()) {
                Package package1 = new Package();
                package1.setId(rs.getInt(1));
                package1.setWeight(rs.getInt("weight"));
                package1.setContentsDescription(rs.getString("contentsDescription"));
                packages.add(package1);
            }
            conn.close();
            return packages;
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        } 

        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

}
