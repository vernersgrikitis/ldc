package com.example.ldc.service;

import com.example.ldc.owner.Owner;
import com.example.ldc.repository.VehicleRepository;
import com.example.ldc.vehicle.Vehicle;
import com.example.ldc.vehicle.addVehicleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public void saveVehicle(addVehicleRequest request) {
        if (vehicleRepository.findVehicleByVinNumber(request.getVinNumber()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Vehicle with VIN number " + request.getVinNumber() + "already registered! ");
        }


        createVehicle(request);
    }

    private Vehicle createVehicle(addVehicleRequest request) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVinNumber(request.getVinNumber());
        vehicle.setRegistrationNumber(request.getRegistrationNumber());
        vehicle.setManufacturer(request.getManufacturer());
        vehicle.setModel(request.getModel());
        vehicle.setFuel(request.getFuel());
        vehicle.setEngineCapacity(request.getEngineCapacity());
        vehicle.setYearOfProduction(request.getYearOfProduction());
        vehicle.setVehicleRegistrationDate(LocalDateTime.now());
        return vehicle;
    }

    private void createOwner(addVehicleRequest request) {
        Owner owner = new Owner();
        owner.setOwnerIdentityNumber(request.getOwner().getOwnerIdentityNumber());
        owner.setOwnerFirstname(request.getOwner().getOwnerFirstname());
        owner.setOwnerLastname(request.getOwner().getOwnerLastname());
        owner.setOwnerEmail(request.getOwner().getOwnerEmail());
        owner.setOwnerAddress(request.getOwner().getOwnerAddress());
        if (vehicleRepository.findVehicleByVinNumber(request.getVinNumber()).isPresent()) {

        }


    }
}
