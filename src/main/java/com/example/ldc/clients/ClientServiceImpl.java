package com.example.ldc.clients;

import com.example.ldc.owner.Owner;
import com.example.ldc.owner.OwnerRepository;
import com.example.ldc.vehicle.Vehicle;
import com.example.ldc.vehicle.VehicleRepository;
import com.example.ldc.vehicle.AddVehicleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final VehicleRepository vehicleRepository;
    private final OwnerRepository ownerRepository;

    @Override
    public void saveVehicle(AddVehicleRequest request) {
        addVehicleToOwner(request);
        isOwnerExist(request);

    }

    public void isOwnerExist(AddVehicleRequest request) {
        Optional<Owner> optionalOwner = ownerRepository
                .findOwnerByOwnerIdentityNumber
                        (request.getOwner().getOwnerIdentityNumber());

        if (optionalOwner.isPresent()) {
            Owner owner = optionalOwner.get();
            owner.addVehicle(addVehicleToOwner(request));
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
        saveVehicle(vehicle);
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
                request.getOwner().getOwnerIdentityNumber(),
                request.getOwner().getOwnerFirstname(),
                request.getOwner().getOwnerLastname(),
                request.getOwner().getOwnerAddress(),
                request.getOwner().getOwnerEmail(),
                request.getOwner().getVehiclesList()
        );
    }


}
