package com.example.ldc.clients;

import com.example.ldc.owner.Owner;
import com.example.ldc.vehicle.AddVehicleRequest;

public interface ClientService {

    void saveVehicle(AddVehicleRequest request);

    void saveOwner(AddVehicleRequest request);
}
