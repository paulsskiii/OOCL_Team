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
    @Query(value = "SELECT * FROM cargo WHERE destination = :portCode AND DATE(created_at) = :date", nativeQuery = true)
    List<Cargo> findCargoGoingToPortOnDate(@Param("portCode") String portCode, @Param("date") LocalDate date);

    // All cargo coming from selected location for the day
    @Query(value = "SELECT * FROM cargo WHERE origin = :portCode AND DATE(created_at) = :date", nativeQuery = true)
    List<Cargo> findCargoComingFromPortOnDate(@Param("portCode") String portCode, @Param("date") LocalDate date);
        
    // All cargo moving for the day, month, year
    @Query(value = "SELECT * FROM cargo WHERE DATE(created_at) BETWEEN :from AND :to", nativeQuery = true)
    List<Cargo> findCargoMovingOnDate(@Param("from") LocalDate from, @Param("to") LocalDate to);
}