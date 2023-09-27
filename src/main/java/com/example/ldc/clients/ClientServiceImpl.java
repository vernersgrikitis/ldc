package com.example.ldc.clients;

import com.example.ldc.owner.Owner;
import com.example.ldc.owner.OwnerRepository;
import com.example.ldc.owner.OwnerRequest;
import com.example.ldc.vehicle.Vehicle;
import com.example.ldc.vehicle.VehicleRepository;
import com.example.ldc.vehicle.AddVehicleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;

@Service
public class ClientServiceImpl implements ClientService {

    private final VehicleRepository vehicleRepository;
    private final OwnerRepository ownerRepository;

    public ClientServiceImpl(VehicleRepository vehicleRepository, OwnerRepository ownerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void getVehicleRequest(AddVehicleRequest request) {
        Vehicle vehicle = createVehicle(request);
        Owner owner = createOwner(request);
        if(vehicleRepository.existsById(vehicle.getVinNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Vehicle with VIN number "
                    + vehicle.getVinNumber() + " already exist!");
        }
        if(ownerRepository.existsById(request.getOwner().getIdentityNumber())) {
//            owner.addVehicle(vehicle);
            saveOwner(owner);
            vehicle.setOwner(owner);
            saveVehicle(vehicle);
        } else {
            Owner ownerToSave = createOwner(request);
            Vehicle vehicleToSave = createVehicle(request);
            vehicleToSave.setOwner(ownerToSave);
            saveOwner(ownerToSave);
            saveVehicle(vehicleToSave);
        }
    }

    @Override
    public Owner getOwnerById(OwnerRequest request) {
        String ownerId = request.getIdentityNumber();
        Owner owner;
        if(ownerRepository.existsById(ownerId)) {
            owner = ownerRepository.findOwnerByIdentityNumber(ownerId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not registered! ");
        }
        return owner;
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }


    private Vehicle createVehicle(AddVehicleRequest request) {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner(request.getOwner());
        vehicle.setVinNumber(request.getVinNumber());
        vehicle.setRegistrationNumber(request.getRegistrationNumber());
        vehicle.setYearOfProduction(request.getYearOfProduction());
        vehicle.setManufacturer(request.getManufacturer());
        vehicle.setModel(request.getModel());
        vehicle.setFuel(request.getFuel());
        vehicle.setVehicleRegistrationDate(LocalDateTime.now());
        vehicle.setEngineCapacity(request.getEngineCapacity());
        return vehicle;
    }

    private Owner createOwner(AddVehicleRequest request) {
        Owner owner = new Owner();
        owner.setFirstName(request.getOwner().getFirstName());
        owner.setLastName(request.getOwner().getLastName());
        owner.setEmail(request.getOwner().getEmail());
        owner.setAddress(request.getOwner().getAddress());
        owner.setIdentityNumber(request.getOwner().getIdentityNumber());
        return owner;
    }


}
