package com.example.ldc.requests;

import org.springframework.lang.NonNull;
import java.time.LocalDateTime;

public record VehicleRegistrationRequest(String vinNumber,
                                         String registrationNumber,
                                         String manufacturer,
                                         String model,
                                         String fuel,
                                         String engineCapacity,
                                         Integer yearOfProduction,
                                         LocalDateTime vehicleRegistrationDate) {

    public VehicleRegistrationRequest(@NonNull String vinNumber,
                                      @NonNull String registrationNumber,
                                      @NonNull String manufacturer,
                                      @NonNull String model,
                                      @NonNull String fuel,
                                      @NonNull String engineCapacity,
                                      @NonNull Integer yearOfProduction,
                                      @NonNull LocalDateTime vehicleRegistrationDate) {
        this.vinNumber = vinNumber;
        this.registrationNumber = registrationNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.fuel = fuel;
        this.engineCapacity = engineCapacity;
        this.yearOfProduction = yearOfProduction;
        this.vehicleRegistrationDate = vehicleRegistrationDate;
    }

    @Override
    public String toString() {
        return "VehicleRegistrationRequest{" +
                "vinNumber='" + vinNumber + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", fuel='" + fuel + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", vehicleRegistrationDate=" + vehicleRegistrationDate +
                '}';
    }
}
