package com.example.ldc.clients;

import com.example.ldc.owner.Owner;
import com.example.ldc.owner.OwnerRequest;
import com.example.ldc.vehicle.AddVehicleRequest;
import com.example.ldc.vehicle.Vehicle;

public interface ClientService {

    void saveVehicle(Vehicle vehicle);

    void saveOwner(Owner owner);

    void getVehicleRequest(AddVehicleRequest request);

    Owner getOwnerById(OwnerRequest request);
}
