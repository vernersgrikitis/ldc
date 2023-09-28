package com.example.ldc.vehicle;

import com.example.ldc.requests.ChangeOwnerRequest;
import com.example.ldc.requests.VehicleRegistrationRequest;
import com.example.ldc.vehiclehistory.VehicleHistory;

public interface VehicleService {

    void saveVehicle(VehicleRegistrationRequest request);

    void deleteAll();

    void changeOwner(ChangeOwnerRequest request);

    VehicleHistory getVehicleHistoryById(Long id);
}
