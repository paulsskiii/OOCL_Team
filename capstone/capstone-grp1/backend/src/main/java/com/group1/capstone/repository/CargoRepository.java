package com.group1.capstone.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group1.capstone.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    // All cargo going to selected location for the day
    @Query(value = "SELECT * FROM cargo WHERE destination = :portId AND DATE(created_at) = :date", nativeQuery = true)
    List<Cargo> findCargoGoingToPortOnDate(@Param("portId") int portId, @Param("date") LocalDate date);

    // All cargo coming from selected location for the day
    @Query(value = "SELECT * FROM cargo WHERE origin = :portId AND DATE(created_at) = :date", nativeQuery = true)
    List<Cargo> findCargoComingFromPortOnDate(@Param("portId") int portId, @Param("date") LocalDate date);
    
    // All cargo moving for the day, month, year
    @Query(value = "SELECT * FROM cargo WHERE YEAR(created_at) = :year AND MONTH(created_at) = :month AND DAY(created_at) = :day", nativeQuery = true)
    List<Cargo> findCargoMovingOnDate(@Param("year") int year, @Param("month") int month, @Param("day") int day);
    
    // Alternative query 3 using LocalDate
    @Query(value = "SELECT * FROM cargo WHERE DATE(created_at) = :date", nativeQuery = true)
    List<Cargo> findCargoMovingOnDate(@Param("date") LocalDate date);
}