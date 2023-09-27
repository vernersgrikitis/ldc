package com.example.ldc.vehicle;

import com.example.ldc.requests.VehicleRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void saveVehicle(VehicleRegistrationRequest request) {

    }
}
