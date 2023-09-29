package com.example.ldc.client;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void saveClient(SaveClientRequest request) {
        Client client = createClient(request);
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

    private Client createClient(SaveClientRequest request) {
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
        return new Client(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.address(),
                request.identityNumber());
    }

    private GetClientResponse clientResponse(Client client) {
        return new GetClientResponse(
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getAddress());
    }
}
