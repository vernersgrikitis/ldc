package com.example.ldc.vehiclehistory;

import com.example.ldc.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleHistoryRepository extends JpaRepository<VehicleHistory, Long> {

    @Query("SELECT vh FROM vehicle_history vh WHERE vh.vehicle.vehicleId = :id")
    VehicleHistory getVehicleHistoryById(@Param("id")Long id);

}
