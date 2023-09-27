package com.example.ldc.client;

import com.example.ldc.requests.SaveClientRequest;
import com.example.ldc.vehicle.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository, VehicleRepository vehicleRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void saveClient(SaveClientRequest request) {
        Client client = checkClient(request);
        clientRepository.save(client);
    }

    @Override
    public GetClientResponse getClient(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$";
        if(!email.matches(emailRegex)) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is not valid! ");
    }
        var client = clientRepository.findClientByEmail(email);
        return clientResponse(client);
    }

    private Client checkClient(SaveClientRequest request) {
        String email = request.email();
        String id = request.identityNumber();
        if (clientRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    email + " is already registered! ");
        }
        if (clientRepository.existsByIdentityNumber(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dear " + request.firstName() +
                    " " + request.lastName() + " something must be wrong check your Identity number! ");
        }
        return createClient(request);
    }

    private Client createClient(SaveClientRequest request) {
        return new Client(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.address(),
                request.identityNumber(),
                parser(request.dateOfBirth()));
    }

    private LocalDateTime parser(String textToParse) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = null;
        try {
            dateTime = LocalDateTime.of(LocalDate.parse(textToParse, formatter), LocalTime.MIDNIGHT);
        } catch (DateTimeParseException e) {
            System.err.println(e.getMessage());
        }
        if (dateTime == null) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }
        return dateTime;
    }

    private GetClientResponse clientResponse(Client client) {
        return new GetClientResponse(
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getAddress());
    }
}
