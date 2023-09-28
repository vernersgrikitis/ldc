package com.example.ldc.vehicle;

import com.example.ldc.client.Client;
import com.example.ldc.client.ClientRepository;
import com.example.ldc.client.ClientService;
import com.example.ldc.client.ClientServiceImpl;
import com.example.ldc.requests.SaveClientRequest;
import com.example.ldc.requests.VehicleRegistrationRequest;
import com.example.ldc.vehiclehistory.VehicleHistory;
import com.example.ldc.vehiclehistory.VehicleHistoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        vehicleRepository.save(registerVehicle(request));
    }

    private Vehicle registerVehicle(VehicleRegistrationRequest request) {
        if (vehicleRepository.existsByVinNumber(request.vinNumber())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Vehicle " + request.vinNumber() + " already registered!");
        }
        return createVehicle(request);
    }

    private Vehicle createVehicle(VehicleRegistrationRequest request) {
        return new Vehicle(
                request.vinNumber(),
                request.registrationNumber(),
                request.manufacturer(),
                request.model(),
                request.fuel(),
                request.engineCapacity(),
                request.yearOfProduction(),
                LocalDateTime.now(),
                createHistory(request)
        );
    }

    private List<VehicleHistory> createHistory(VehicleRegistrationRequest request) {
        List<VehicleHistory> historyList = new ArrayList<>();

        if (clientRepository.existsByIdentityNumber(request.clientRequest().identityNumber())) {
            Client registeredClient = clientRepository.getClientByIdentityNumber(request.clientRequest().identityNumber());
            VehicleHistory history = new VehicleHistory();
            history.setStartOfOwnership(LocalDateTime.now());
            history.setVehicle(createVehicle(request));
            history.setCurrentOwner(registeredClient);
            historyList.add(history);
        } else {
            Client client = clientServiceImpl.createClient(request.clientRequest());
            VehicleHistory history = new VehicleHistory();
            history.setStartOfOwnership(LocalDateTime.now());
            history.setVehicle(createVehicle(request));
            history.setCurrentOwner(client);
            historyList.add(history);
        }

        vehicleHistoryRepository.saveAll(historyList);

        return historyList;
    }
}
