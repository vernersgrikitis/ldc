package com.example.ldc.vehicle;

import com.example.ldc.vehiclehistory.VehicleHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> getVehicleByVinNumber(String vinNumber);

}
