package com.example.ldc.clients;

import com.example.ldc.owner.Owner;
import com.example.ldc.owner.OwnerRepository;
import com.example.ldc.vehicle.Vehicle;
import com.example.ldc.vehicle.VehicleRepository;
import com.example.ldc.vehicle.AddVehicleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final VehicleRepository vehicleRepository;
    private final OwnerRepository ownerRepository;

    @Override
    public void saveVehicle(AddVehicleRequest request) {
        Vehicle vehicle = addVehicleToOwner(request);
        isOwnerExist(request);
        saveVehicle(vehicle);
    }

    public void isOwnerExist(AddVehicleRequest request) {
        Optional<Owner> optionalOwner = ownerRepository
                .findOwnerByIdentityNumber
                        (request.getOwner().getIdentityNumber());

        if (optionalOwner.isPresent()) {
            Owner owner = optionalOwner.get();
            Vehicle vehicle = createVehicle(request);
            saveVehicle(vehicle);
            owner.addVehicle(vehicle);
        } else {
            Owner owner = createOwner(request);
            owner.addVehicle(addVehicleToOwner(request));
        }
    }

    public Vehicle addVehicleToOwner(AddVehicleRequest request) {
        if (vehicleRepository.findVehicleByVinNumber(request.getVinNumber()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Vehicle with VIN number "
                            + request.getVinNumber()
                            + "already registered! ");
        }
        Vehicle vehicle = createVehicle(request);
        Owner owner = getOrCreateOwner(request);
        vehicle.setOwner(owner);
        owner.addVehicle(vehicle);
        return vehicle;
    }

    public void saveOwner(AddVehicleRequest request) {
        Owner owner = createOwner(request);
        ownerRepository.save(owner);
        throw new ResponseStatusException(HttpStatus.CREATED,
                "Client saved successfully! ");
    }

    public void saveVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        throw new ResponseStatusException(HttpStatus.CREATED,
                "Vehicle saved successfully! ");
    }

    private Vehicle createVehicle(AddVehicleRequest request) {
        return Vehicle
                .builder()
                .vinNumber(request.getVinNumber())
                .registrationNumber(request.getRegistrationNumber())
                .manufacturer(request.getManufacturer())
                .model(request.getModel())
                .fuel(request.getFuel())
                .engineCapacity(request.getEngineCapacity())
                .yearOfProduction(request.getYearOfProduction())
                .vehicleRegistrationDate(LocalDateTime.now())
                .build();
    }

    private Owner createOwner(AddVehicleRequest request) {
        return new Owner(
                request.getOwner().getIdentityNumber(),
                request.getOwner().getFirstName(),
                request.getOwner().getLastName(),
                request.getOwner().getAddress(),
                request.getOwner().getEmail(),
                request.getOwner().getVehicles()
        );
    }

    private Owner getOrCreateOwner(AddVehicleRequest request) {
        Optional<Owner> optionalOwner = ownerRepository
                .findOwnerByIdentityNumber(request.getOwner().getIdentityNumber());

        return optionalOwner.orElseGet(() -> createOwner(request));
    }


}
