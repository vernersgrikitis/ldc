package com.example.ldc.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle getVehicleByVinNumber(String vinNumber);

    boolean existsByVinNumber(String vinNumber);
}
