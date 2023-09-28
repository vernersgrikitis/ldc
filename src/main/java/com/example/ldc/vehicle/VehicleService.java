package com.example.ldc.vehicle;

import com.example.ldc.requests.VehicleRegistrationRequest;

public interface VehicleService {

    Vehicle saveVehicle(VehicleRegistrationRequest request);
}
