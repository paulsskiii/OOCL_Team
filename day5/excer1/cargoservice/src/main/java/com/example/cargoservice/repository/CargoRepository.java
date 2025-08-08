package com.example.cargoservice.repository;

import com.example.cargoservice.model.CargoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<CargoItem, Long> {
    List<CargoItem> findByOrigin(String origin);
    List<CargoItem> findByDestination(String destination);
    List<CargoItem> findByWeightBetween(double minWeight, double maxWeight);

    @Query("SELECT c FROM CargoItem c WHERE c.origin LIKE %?1%")
    List<CargoItem> findByOriginContaining(String originPattern);
}


