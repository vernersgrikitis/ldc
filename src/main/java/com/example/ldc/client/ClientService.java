package com.example.ldc.client;

import com.example.ldc.requests.SaveClientRequest;

public interface ClientService {

    void saveClient(SaveClientRequest request);

    GetClientResponse getClient(String email);
}
