package com.example.ldc.client;

import com.example.ldc.requests.SaveClientRequest;

import java.util.Optional;

public interface ClientService {

    void saveClient(SaveClientRequest request);

    GetClientResponse getClientByEmail(String email);

}
