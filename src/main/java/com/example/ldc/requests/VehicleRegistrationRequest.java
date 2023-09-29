package com.example.ldc.requests;

import org.springframework.lang.NonNull;

public record VehicleRegistrationRequest(String vinNumber,
                                         String registrationNumber,
                                         String manufacturer,
                                         String model,
                                         String fuel,
                                         String engineCapacity,
                                         Integer yearOfProduction,
                                         SaveClientRequest clientRequest) {

    public VehicleRegistrationRequest(@NonNull String vinNumber,
                                      @NonNull String registrationNumber,
                                      @NonNull String manufacturer,
                                      @NonNull String model,
                                      @NonNull String fuel,
                                      @NonNull String engineCapacity,
                                      @NonNull Integer yearOfProduction,
                                      @NonNull SaveClientRequest clientRequest) {
        this.vinNumber = vinNumber;
        this.registrationNumber = registrationNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.fuel = fuel;
        this.engineCapacity = engineCapacity;
        this.yearOfProduction = yearOfProduction;
        this.clientRequest = clientRequest;
    }

}
