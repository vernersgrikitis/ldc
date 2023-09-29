package com.example.ldc.vehicle;

import com.example.ldc.client.Client;
import com.example.ldc.client.ClientRepository;
import com.example.ldc.client.ClientServiceImpl;
import com.example.ldc.requests.VehicleRegistrationRequest;
import com.example.ldc.vehiclehistory.VehicleHistory;
import com.example.ldc.vehiclehistory.VehicleHistoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ClientRepository clientRepository;
    private final VehicleHistoryRepository vehicleHistoryRepository;
    private final ClientServiceImpl clientServiceImpl;

    public VehicleServiceImpl(VehicleRepository vehicleRepository,
                              ClientRepository clientRepository,
                              VehicleHistoryRepository vehicleHistoryRepository,
                              ClientServiceImpl clientServiceImpl) {
        this.vehicleRepository = vehicleRepository;
        this.clientRepository = clientRepository;
        this.vehicleHistoryRepository = vehicleHistoryRepository;
        this.clientServiceImpl = clientServiceImpl;
    }

    @Override
    public Vehicle saveVehicle(VehicleRegistrationRequest request) {
        return registerVehicle(request);
    }

    private Vehicle registerVehicle(VehicleRegistrationRequest request) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleByVinNumber(request.vinNumber());
        if (optionalVehicle.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Vehicle " + request.vinNumber() + " already registered!");
        }
        return createVehicleHistory(request);
    }

    private Vehicle createVehicleHistory(VehicleRegistrationRequest request) {
        VehicleHistory history = new VehicleHistory();
        history.setStartOfOwnership(LocalDateTime.now());
        history.setVehicle(createVehicle(request));
        history.setCurrentOwner(getOrRegisterClient(request));
        vehicleHistoryRepository.save(history);
        return createVehicle(request);
    }

    private Client getOrRegisterClient(VehicleRegistrationRequest request) {
        Optional<Client> optionalClient = clientRepository.getClientByIdentityNumber(request.clientRequest().identityNumber());
        Client client = null;
        client = optionalClient.orElseGet(() -> clientServiceImpl.createClient(request.clientRequest()));
        clientRepository.save(client);
        return client;
    }

    private Vehicle createVehicle(VehicleRegistrationRequest request) {
        Vehicle vehicle = new Vehicle(
                request.vinNumber(),
                request.registrationNumber(),
                request.manufacturer(),
                request.model(),
                request.fuel(),
                request.engineCapacity(),
                request.yearOfProduction(),
                LocalDateTime.now());
        vehicleRepository.save(vehicle);
        return vehicle;
    }

}
