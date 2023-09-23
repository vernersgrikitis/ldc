package com.example.ldc.vehicle;

import com.example.ldc.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface VehicleRepository extends JpaRepository <Vehicle, String> {

    Optional<Vehicle> findVehicleByVinNumber(String vinNumber);


}
