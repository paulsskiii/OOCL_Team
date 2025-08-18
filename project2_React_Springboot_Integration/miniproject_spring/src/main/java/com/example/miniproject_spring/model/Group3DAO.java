package com.example.miniproject_spring.model;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;


public class Group3DAO {
    Connection con;

    public <T> T getStatementResultList(final String SQL, Class<?> objectClass, Object... params) {
        con = DbConnection.getConnection();    
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                return mapToEntity(objectClass, rs);
            }catch(Exception  e){
                System.err.println("Error closing database connection!");
                System.err.println("SQL State: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
            }
        }
        DbConnection.closeConnection(con);
        return null;
    }

    public <T> T getPreparedStatementResultList(final String SQL, Class<?> objectClass, Object... params) {
        con = DbConnection.getConnection();    
        if(con != null){
            try{
                ResultSet rs = runPreparedStatement(SQL, params);
                return mapToEntity(objectClass, rs);
            }catch(Exception  e){
                System.err.println("Error closing database connection!");
                System.err.println("SQL State: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
            }
        }
        DbConnection.closeConnection(con);
        return null;
    }

    public <T> T getPreparedStatementSingleResultList(final String SQL, Class<?> objectClass, Object... params) {
        con = DbConnection.getConnection();    
        if(con != null){
            try{
                ResultSet rs = runPreparedStatement(SQL, params);
                return mapToEntitySingleResult(objectClass, rs);
            }catch(Exception  e){
                System.err.println("Error closing database connection!");
                System.err.println("SQL State: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
            }
        }
        DbConnection.closeConnection(con);
        return null;
    }

    public <T> T getCallableStatementResultList(final String SQL, Class<?> objectClass, Object... params) {
        con = DbConnection.getConnection();    
        if(con != null){
            try{
                ResultSet rs = runCallableStatement(SQL, params);
                return mapToEntity(objectClass, rs);
            }catch(Exception  e){
                System.err.println("Error closing database connection!");
                System.err.println("SQL State: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
            }
        }
        DbConnection.closeConnection(con);
        return null;
    }


    public ResultSet runPreparedStatement(final String SQL, Object... params) throws SQLException{
        PreparedStatement stmt;
        int parameterIndex = 1;
        stmt = con.prepareStatement(SQL);
        for(Object param : params){
            System.out.println(parameterIndex + " - - "+ param);
            stmt.setObject(parameterIndex, param);
            parameterIndex++;
        }
        stmt.execute();
        return stmt.getResultSet();
    }

    public ResultSet runCallableStatement(final String SQL, Object... params) throws SQLException{
        CallableStatement stmt;
        int parameterIndex = 1;
        stmt = con.prepareCall(SQL);
        for(Object param : params){
            stmt.setObject(parameterIndex, param);
            parameterIndex++;
        }
        stmt.executeQuery();
        return stmt.getResultSet();
    }

    public <T> T mapToEntity(Class<?> objectClass, ResultSet rs) throws Exception{
        List<T> result = new ArrayList<>();
        Map<String, Object> properties = new HashMap<>();
        if(rs != null){
            while(rs.next()){
                int i = 1;
                T instance =  (T) objectClass.getDeclaredConstructor().newInstance();
                for(Field field : objectClass.getDeclaredFields()){
                    String fieldName = field.getName();
                    properties.put(fieldName, rs.getObject(i));
                    i++;
                }          
                BeanUtils.populate(instance, properties);         
                result.add(instance);
            };
        }
        DbConnection.closeConnection(con);
        return (T) result;
    }

    public <T> T mapToEntitySingleResult(Class<?> objectClass, ResultSet rs) throws Exception{
        Map<String, Object> properties = new HashMap<>();
        T instance =  (T) objectClass.getDeclaredConstructor().newInstance();
        if(rs != null){
            while(rs.next()){
                int i = 1;
                for(Field field : objectClass.getDeclaredFields()){
                    String fieldName = field.getName();
                    properties.put(fieldName, rs.getObject(i));
                    i++;
                }          
                BeanUtils.populate(instance, properties);         
            
            };
        }
        DbConnection.closeConnection(con);
        return (T) instance;
    }
}
