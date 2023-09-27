package com.example.ldc.client;

public interface ClientService {

    void saveClient(SaveClientRequest request);

    GetClientResponse getClient(String email);
}
