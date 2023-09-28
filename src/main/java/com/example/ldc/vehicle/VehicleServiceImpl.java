package com.example.ldc.vehicle;

import com.example.ldc.client.Client;
import com.example.ldc.client.ClientRepository;
import com.example.ldc.client.ClientServiceImpl;
import com.example.ldc.requests.ChangeOwnerRequest;
import com.example.ldc.requests.VehicleRegistrationRequest;
import com.example.ldc.vehiclehistory.VehicleHistory;
import com.example.ldc.vehiclehistory.VehicleHistoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;
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
    public void saveVehicle(VehicleRegistrationRequest request) {
        registerVehicle(request);
    }

    @Override
    public void deleteAll() {
        vehicleRepository.deleteAll();
        vehicleHistoryRepository.deleteAll();
        clientRepository.deleteAll();
        throw new ResponseStatusException(HttpStatus.OK, "All repository's deleted! ");
    }

    @Override
    public void changeOwner(ChangeOwnerRequest request) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleByVinNumber(request.vinNumber());
        Vehicle vehicle = null;
        if (optionalVehicle.isPresent()) {
            vehicle = optionalVehicle.get();
        }
        VehicleHistory carHistory = vehicleHistoryRepository.getVehicleHistoryById(vehicle != null ? vehicle.getVehicleId() : null);
        Client seller = carHistory.getCurrentOwner();
        clientServiceImpl.saveClient(request.newOwner());
        Client newOwner = clientServiceImpl.getClientByIdentificationNumber(request.newOwner().identityNumber());

        carHistory.setEndOfOwnership(LocalDateTime.now());
        carHistory.setPreviousOwner(seller);
        carHistory.setCurrentOwner(newOwner);
        carHistory.setStartOfOwnership(LocalDateTime.now());
        vehicleHistoryRepository.save(carHistory);


        List<VehicleHistory> oldHistory = vehicle.getOwnershipHistory();
        oldHistory.add(carHistory);
        vehicle.setOwnershipHistory(oldHistory);
        vehicleRepository.save(vehicle);
    }

    @Override
    public VehicleHistory getVehicleHistoryById(Long id) {
        return vehicleHistoryRepository.getVehicleHistoryById(id);
    }


    private void registerVehicle(VehicleRegistrationRequest request) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleByVinNumber(request.vinNumber());
        if (optionalVehicle.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Vehicle " + request.vinNumber() + " already registered!");
        }
        createVehicleHistory(request);
    }

    private void createVehicleHistory(VehicleRegistrationRequest request) {
        VehicleHistory history = new VehicleHistory();
        history.setStartOfOwnership(LocalDateTime.now());
        history.setVehicle(createVehicle(request));
        history.setCurrentOwner(getOrRegisterClient(request));
        vehicleHistoryRepository.save(history);
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
